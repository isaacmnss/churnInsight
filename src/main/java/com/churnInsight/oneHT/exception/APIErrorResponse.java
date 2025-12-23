package com.churnInsight.oneHT.exception;

import java.time.LocalDateTime;
import java.util.List;

public record APIErrorResponse(
        LocalDateTime timeStamp,
        Integer status,
        String erro,
        String mensagem,
        String path,
        List<FieldErrorResponse> fieldErrors
) {
}
