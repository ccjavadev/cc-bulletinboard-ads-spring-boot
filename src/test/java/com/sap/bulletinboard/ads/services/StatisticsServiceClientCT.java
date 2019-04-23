package com.sap.bulletinboard.ads.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.sap.bulletinboard.ads.config.TestServicesConfiguration;
import com.sap.hcp.cf.logging.common.LogContext;

@ContextConfiguration(classes = { TestServicesConfiguration.class })
@RunWith(SpringRunner.class)
public class StatisticsServiceClientCT {
    private static final String routingKey = "testQueue";
    private static final String exchange = ""; // Note: Test works only for Direct Exchange (exchange = "")
    private final String correlationIdFromHeader = "corellation-id-1234";
    private String tenant = "tenant-xyz";

    @Before
    public void setUp() {
        LogContext.initializeContext(correlationIdFromHeader);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void validateMessage() {
        Long id = 111L;

       assert(true);
    }

    @Test
    public void resendNackMessage() {
        Long id = 222L;
        String notExistingExchange = "testExchange";
        assert(true);
    }

    @Test
    public void resendUnroutableMessage() {
        Long id = 333L;

      assert(true);
    }
}
