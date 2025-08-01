package com.project.iatest.controller;

import com.project.iatest.entity.Itinerary;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPlanController {

    public final ChatClient chatClient;

    public VacationPlanController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/vacation")
    public Itinerary structured() {
        return chatClient.prompt()
                .user("I want to plan a trip to Hawaii. Give me a list of things to do.")
                .call()
                .entity(Itinerary.class);
    }
}
