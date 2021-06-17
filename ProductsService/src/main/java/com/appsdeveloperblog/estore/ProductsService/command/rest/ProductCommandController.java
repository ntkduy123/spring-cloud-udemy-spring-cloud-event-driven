package com.appsdeveloperblog.estore.ProductsService.command.rest;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel restModel) {
        CreateProductCommand command = CreateProductCommand.builder()
                .price(restModel.getPrice())
                .quantity(restModel.getQuantity())
                .title(restModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;
        try {
            returnValue = commandGateway.sendAndWait(command);
        } catch (Exception ex) {
            returnValue = ex.getLocalizedMessage();
        }

        return returnValue;
    }
}
