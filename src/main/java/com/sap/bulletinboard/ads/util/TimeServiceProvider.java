package com.sap.bulletinboard.ads.util;

import java.time.Instant;

public class TimeServiceProvider {

    private static volatile TimeService timeService = new TimeService() {
        @Override
        public String now() {
            return Instant.now().toString();
        }
    };

    /** Can be used to mock time during tests */
    public static void setTimeService(TimeService newService) {
        timeService = newService;
    }

    public static String now() {
        return timeService.now();
    }

}
