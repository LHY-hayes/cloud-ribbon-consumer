package com.hayes.code.cloudribbonconsumer.controller;

import com.hayes.code.cloudribbonconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate ;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer(){

        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();

    }


    @RequestMapping("/ribbon-consumer/userStr")
    public String helloConsumer_user_str(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user?name={1}", String.class, "didi");
        String body = responseEntity.getBody();
        return body ;

    }

    @RequestMapping("/ribbon-consumer/user")
    public User helloConsumer_user(){

        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user?name={1}", User.class, "didi");
        User body = responseEntity.getBody();
        return body ;

    }


}
