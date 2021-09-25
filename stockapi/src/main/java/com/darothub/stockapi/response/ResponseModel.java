package com.darothub.stockapi.response;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
@EqualsAndHashCode(callSuper = false)
public class ResponseModel {
    private int status;
    private String message;
    private Object payload;
}