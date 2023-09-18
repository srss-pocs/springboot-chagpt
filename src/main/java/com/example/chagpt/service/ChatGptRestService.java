package com.example.chagpt.service;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.chagpt.model.ChatGPTRequest;
import com.example.chagpt.model.ChatGPTResponse;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatGptRestService {

	 @Value("${OPEN_AI_URL}")
	    private String OPEN_AI_URL;

	    @Value("${OPEN_AI_KEY}")
	    private String OPEN_AI_KEY;

	    public String processSearch(String query) {

	        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
	        chatGPTRequest.setPrompt(query);


	        String url = OPEN_AI_URL;

	        HttpPost post = new HttpPost(url);
	        post.addHeader("Content-Type", "application/json");
	        post.addHeader("Authorization", "Bearer " + OPEN_AI_KEY);

	        Gson gson = new Gson();

	        String body = gson.toJson(chatGPTRequest);

	        log.info("body: " + body);

	        try {
	            final StringEntity entity = new StringEntity(body);
	            post.setEntity(entity);

	            try (CloseableHttpClient httpClient = HttpClients.custom().build();
	                 CloseableHttpResponse response = httpClient.execute(post)) {

	                String responseText = EntityUtils.toString(response.getEntity());

	                log.info("response: " + responseText);

	                ChatGPTResponse chatGPTResponse = gson.fromJson(responseText, ChatGPTResponse.class);

	                return chatGPTResponse.getChoices().get(0).getText();
	            } catch (Exception ex) {
	                return "failed response : "+ex.getMessage();
	            }
	        }
	        catch (Exception e) {
	            return "failed to call chatgpt";
	        }



	    }
    
}
