package com.appsdeveloperblog.estore.ProductsService.command.interceptors;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.BiFunction;

public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductCommandInterceptor.class);

    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> list) {
        return (index, command) -> {

            LOGGER.info("Intercepted command: " + command.getPayloadType());
            if(CreateProductCommand.class.equals(command.getPayloadType())) {

                CreateProductCommand createProductCommand = (CreateProductCommand)command.getPayload();

            }

            return command;
        };
    }
}
