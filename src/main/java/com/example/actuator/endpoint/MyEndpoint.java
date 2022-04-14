package com.example.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "myendpoint")
public class MyEndpoint {

    //@ReadOperation, @WriteOperation, @DeleteOperation注解，分别对应生成Get/Post/Delete的Mapping
    @ReadOperation
    public Map getDocketInfo(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("status","正常");
        map.put("name","xyl");
        return map;
    }

    @WriteOperation
    public Map getDocketInfo2(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("write-operation","postMapping");
        return map;
    }

    @DeleteOperation
    public Map getDocketInfo3(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("delete-operation","deleteMapping");
        return map;
    }

}
