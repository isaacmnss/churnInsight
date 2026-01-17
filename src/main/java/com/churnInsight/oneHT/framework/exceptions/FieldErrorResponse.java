package com.churnInsight.oneHT.framework.exceptions;

public record FieldErrorResponse(
        String campo,
        String mensagem
) {
}
