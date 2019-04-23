package com.sap.bulletinboard.ads.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.sap.bulletinboard.ads.config.TestServicesConfiguration;
import com.sap.hcp.cf.logging.common.LogContext;

@ContextConfiguration(classes = { TestServicesConfiguration.class })
@RunWith(SpringRunner.class)
public class StatisticsServiceClientTest {
    private static final String routingKey = "testQueue";
    private static final String exchange = "testX";
    private final String correlationIdFromHeader = "corellation-id-1234";


    private StatisticsServiceClient statisticsServiceClient;

    @Before
    public void setUp() {
        LogContext.initializeContext(correlationIdFromHeader);
        statisticsServiceClient = new StatisticsServiceClient(exchange, routingKey);
    }

    @Test
    public void validateMessage() {
        Long id = 555L;
        String tenant = "tenant-xyz";
        assert(true);
    }
}
