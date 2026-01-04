package com.churnInsight.oneHT.framework.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tools.jackson.databind.exc.InvalidFormatException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIErrorResponse> handleInvalidEnum(
            HttpMessageNotReadableException ex,
            HttpServletRequest request
    ) {

        String message = "Valor inválido para um dos campos";

        if (ex.getCause() instanceof InvalidFormatException e
                && e.getTargetType().isEnum()) {

            String fieldName = e.getPath().getFirst().getPropertyName();

            message = String.format(
                    "Valor inválido para o campo '%s'. Valores aceitos: %s",
                    fieldName,
                    Arrays.toString(e.getTargetType().getEnumConstants())
            );
        }

        APIErrorResponse response = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                "Erro de validação",
                message,
                request.getRequestURI(),
                null
        );

        return ResponseEntity
                .unprocessableContent()
                .body(response);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<APIErrorResponse> handleValidationError(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ){
        List<FieldErrorResponse> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorResponse(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();

        APIErrorResponse response = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                "Dados inválidos",
                request.getRequestURI(),
                fieldErrors
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ExceptionNegocio.class)
    public ResponseEntity<APIErrorResponse> handleBusinessException(
            ExceptionNegocio ex,
            HttpServletRequest request
    ) {

        APIErrorResponse response = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                "Business Error",
                ex.getMessage(),
                request.getRequestURI(),
                null
        );

        return ResponseEntity.unprocessableContent().body(response);
    }

    public ResponseEntity<APIErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request
    ) {

        APIErrorResponse response = new APIErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Erro inesperado",
                request.getRequestURI(),
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
