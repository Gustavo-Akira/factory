package br.com.gustavoakira.industry.factory.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private String product;
    private Integer quantity;
}
