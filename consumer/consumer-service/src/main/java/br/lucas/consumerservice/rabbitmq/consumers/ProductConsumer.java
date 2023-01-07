package br.lucas.consumerservice.rabbitmq.consumers;

import br.lucas.consumerservice.rabbitmq.dtos.ProdutoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static br.lucas.consumerservice.rabbitmq.constants.RabbitMQConstants.ROUTING_KEY_PRODUCT_LOG;

@Log4j2
@Component
public class ProductConsumer {

    @RabbitListener(queues = {ROUTING_KEY_PRODUCT_LOG})
    public void consumerLog(ProdutoDTO produto) {
        log.info("Received message " + produto.toString());
    }

}