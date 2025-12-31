package com.churnInsight.oneHT.exception;

public record FieldErrorResponse(
        String campo,
        String mensagem
) {
}
