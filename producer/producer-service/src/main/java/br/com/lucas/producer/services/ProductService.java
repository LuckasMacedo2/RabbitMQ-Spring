package br.com.lucas.producer.services;

import br.com.lucas.producer.services.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.lucas.producer.configs.RabbitMQConfig.EXCHANGE_NAME_MARKETPLACE;
import static br.com.lucas.producer.configs.RabbitMQConfig.ROUTING_KEY_PRODUCT_LOG;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {
    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto) {
        log.info("Sending a message to exchange " + dto.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, dto);
    }
}
