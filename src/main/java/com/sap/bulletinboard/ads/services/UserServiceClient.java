package com.sap.bulletinboard.ads.services;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.sap.bulletinboard.ads.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
public class UserServiceClient {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static final String RESOURCE_NAME = "api/v1.0/users";
    private final RestTemplate restTemplate;

    @Value("${USER_ROUTE}")
    private String userServiceRoute;

    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isPremiumUser(String id) {
        return true;
    }

    private User hystrixFallback(GetUserCommand getUserCommand) {
        // there is no use in performing a retry if the command is short-circuited
        if (getUserCommand.isCircuitBreakerOpen()) {
            return new User();
        }

        // note: retry logic is only triggered for HystrixRuntimeException exceptions, therefore we throw an exception
        // here so to cause Hystrix to throw such an exception
        throw new UnsupportedOperationException("Propagate to Spring Retry");
        // you may also consider the state of the Hystrix command via the getUserCommand parameter to decide if you
        // want to provide an actual fallback User or let recoverFromExhaustedRetry() handle the recovery
        // return new User();
    }

    boolean recoverFromExhaustedRetry(HystrixRuntimeException e) {
        logger.warn("recovery mode: exhausted retries, applying default", e);
        return false;
    }

    boolean recoverFromClientError(HystrixBadRequestException e) throws Throwable {
        return defaultRecoverStrategy(e.getCause());
    }

    boolean defaultRecoverStrategy(Throwable e) throws Throwable {
        logger.warn("recovery mode: default handler for non-server-side errors");
        throw e;
    }

}
