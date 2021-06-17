package com.appsdeveloperblog.estore.ProductsService.query;

import com.appsdeveloperblog.estore.ProductsService.core.data.ProductRepository;
import com.appsdeveloperblog.estore.ProductsService.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsQueryHandler {

    private final ProductRepository productRepository;

    public ProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductQuery query) {
        List<ProductRestModel> products = productRepository.findAll()
                .stream().map(p -> ProductRestModel.builder()
                        .productId(p.getProductId())
                        .price(p.getPrice())
                        .quantity(p.getQuantity())
                        .title(p.getTitle())
                        .build())
                .collect(Collectors.toList());

        return products;
    }
}
