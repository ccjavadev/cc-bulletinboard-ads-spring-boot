package com.sap.bulletinboard.ads.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StatisticsServiceClient {

    public static final String MSG_HEADER_TENANT = "tenant";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String routingKey; // Queue Name
    private final String exchange;
//    private final RabbitTemplate rabbitTemplate;

    public StatisticsServiceClient(@Value("${bulletinboard.rabbit.adIsShown.exchange}") String exchangeName,
                                   @Value("${bulletinboard.rabbit.adIsShown.queue_increaseViewCount}") String queueName) {

        this.routingKey = queueName;
        this.exchange = exchangeName;
        setupCallbacks();
    }

    public void advertisementIsShown(Long id, String tenant) throws RuntimeException {
        send(id, tenant);
    }

    private void setupCallbacks() {
    }

    public void send(Long id, String tenant) throws RuntimeException {
        logger.info("sending message '{}' for routing key '{}'", id, routingKey);
    }
}