package com.example.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class MyComInfoIndicator implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","first time to write")
                .withDetails(Collections.singletonMap("name","xyl"));


    }
}
