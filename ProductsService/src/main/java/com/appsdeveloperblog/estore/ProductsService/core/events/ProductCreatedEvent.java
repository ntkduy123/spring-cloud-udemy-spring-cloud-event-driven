package com.appsdeveloperblog.estore.ProductsService.core.events;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductCreatedEvent {

    private final String productId;
    private final String title;
    private final BigDecimal price;
    private final Integer quantity;
}
