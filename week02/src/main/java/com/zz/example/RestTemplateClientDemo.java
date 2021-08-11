package com.zz.example;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


/**
 * @author sp0038
 * @date 2021/8/11
 */
public class RestTemplateClientDemo {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8081", HttpMethod.GET, null, String.class, new HashMap<>());
        System.out.println(responseEntity.getBody());
    }
}
