package br.com.lucas.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.lucas.producer.configs.RabbitMQConfig.EXCHANGE_NAME_MARKETPLACE;
import static br.com.lucas.producer.configs.RabbitMQConfig.ROUTING_KEY_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {
    private  final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, message);
    }
}
