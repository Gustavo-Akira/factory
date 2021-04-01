package br.com.gustavoakira.industry.factory.dto;

import com.fasterxml.jackson.core.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddDTO {
    private Integer quantity;
    private ProductDTO product;
}
