package com.example.chagpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chagpt.model.SearchRequest;
import com.example.chagpt.service.ChatGptRestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class ChatGptRestController {

	@Autowired
	private ChatGptRestService chatGptRestService;

    @PostMapping("/searchchatgpt")
    public String searchChatGPT(@RequestBody SearchRequest searchRequest) {

        log.info("query: " + searchRequest.getQuery());

        return chatGptRestService.processSearch(searchRequest.getQuery());

    }
    
}
