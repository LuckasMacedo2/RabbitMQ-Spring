package br.lucas.consumerservice.rabbitmq.consumers;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumer {
    @RabbitListener(queues = {"product.log"}) // Definição da fila ao qual o consumidor está ouvindo
    public void consumer(String message) {
        log.info("Consumer received a message: " + message);
    }
}
