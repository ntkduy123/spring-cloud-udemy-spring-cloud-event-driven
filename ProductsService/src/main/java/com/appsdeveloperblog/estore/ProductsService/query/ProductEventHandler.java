package com.appsdeveloperblog.estore.ProductsService.query;

import com.appsdeveloperblog.estore.ProductsService.core.data.ProductEntity;
import com.appsdeveloperblog.estore.ProductsService.core.data.ProductRepository;
import com.appsdeveloperblog.estore.ProductsService.core.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent, productEntity);

        productRepository.save(productEntity);
    }
}
