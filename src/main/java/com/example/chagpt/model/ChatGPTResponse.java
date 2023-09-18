package com.example.chagpt.model;

import java.util.List;

import lombok.Data;

@Data
public class ChatGPTResponse {
    private List<ChatGptChoice> choices;
}
