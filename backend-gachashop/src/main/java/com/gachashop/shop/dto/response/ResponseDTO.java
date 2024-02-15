package com.gachashop.shop.dto.response;

public class ResponseDTO {

    private final String error;

    public ResponseDTO(RuntimeException e) {
        this.error = e.getMessage();
    }
}
