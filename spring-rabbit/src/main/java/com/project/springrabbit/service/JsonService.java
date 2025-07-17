package com.project.springrabbit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springrabbit.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class JsonService {
    private final ObjectMapper mapper;

    public void parseMessageToResponse(final Message message) {
        byte[] body = message.getBody();
        String jsonString = new String(body);

        try {
            ClientResponse response = mapper.readValue(jsonString, ClientResponse.class);
            Map<String, Object> map = mapper.convertValue(response, new HashMap<String, Object>().getClass());
            formatter(map);
            log.info("Map {}", map);
        } catch (Exception e) {
            log.error("Erro ao fazer o mapper para o response ", e);
        }
    }

    public void formatter(Map<String, Object> map) {
        if (map.containsKey("codeProduct")) {
            if (map.get("codeProduct").equals(101)) {
                map.put("codeProduct", "TEST_PRODUCT");
            }
        }
    }
}
