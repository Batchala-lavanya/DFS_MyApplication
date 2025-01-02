package com.demo.task.PactTest;
 
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
 
import com.fasterxml.jackson.databind.ObjectMapper;
 
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;

import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;

import au.com.dius.pact.consumer.junit5.PactTestFor;

import au.com.dius.pact.core.model.V4Pact;

import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "Provider-user", port = "9091")
public class PactConsumerTest {

    @Pact(consumer = "consumer-user")
    public V4Pact createPact(PactDslWithProvider builder) {

        PactDslJsonBody responseBody = new PactDslJsonBody()
            .integerType("userid", 1)
            .stringType("name", "lavanya13")
            .stringType("email", "lavanya13@gmail.com")
            .stringType("password", "lavanya13");
        return builder
            .given("User with ID 1 exists")
            .uponReceiving("A request to retrieve user with ID 1")
            .path("/mytask/retrieveUser/1")
            .method("GET")
            .willRespondWith()
            .status(200)
            .body(responseBody)
            .toPact(V4Pact.class);

    }

    @Test
    void testPact() throws Exception {

        // Create a RestTemplate to make the HTTP call

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:9091/mytask/retrieveUser/1";


        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(200, response.getStatusCodeValue());

        String expectedBody = "{\"userid\":1,\"name\":\"lavanya13\",\"email\":\"lavanya13@gmail.com\",\"password\":\"lavanya13\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        
        assertEquals(

            objectMapper.readTree(expectedBody),

            objectMapper.readTree(response.getBody())

        );

    }

}

 