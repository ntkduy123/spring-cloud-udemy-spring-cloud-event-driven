package com.appsdeveloperblog.estore.ProductsService.query.rest;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRestModel {
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
