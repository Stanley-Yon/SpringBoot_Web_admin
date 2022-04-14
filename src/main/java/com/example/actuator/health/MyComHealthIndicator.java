package com.example.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 自定义的健康监控器
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        HashMap<String, Object> map = new HashMap<>();

        if(1==2){       // 自己书写具体的判断逻辑
            builder.status(Status.UP);      // 健康
            map.put("num",2);
        }else {
            builder.status(Status.DOWN);    //不健康
            map.put("error", "连接超时");
        }
        builder.withDetails(map)
                .withDetail("code","hello world!!");

    }

}
