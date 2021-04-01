package br.com.gustavoakira.industry.factory.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ProductRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long productId;

    private String productName;

    private Integer quantity;

    @Temporal(TemporalType.DATE)
    private Date dateToDeliver = new Date(System.currentTimeMillis() + 300000000L);
}
