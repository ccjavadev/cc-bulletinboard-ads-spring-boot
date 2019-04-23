package com.sap.bulletinboard.ads.testutils;

import java.time.Instant;

import com.sap.bulletinboard.ads.util.TimeService;

public class TimeServiceFake implements TimeService {

    private final String instant;

    public TimeServiceFake(String instant) {
        this.instant = instant;
    }

    @Override
    public String now() {
        return instant;
    }

}
