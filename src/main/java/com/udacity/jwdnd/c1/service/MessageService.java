package com.udacity.jwdnd.c1.service;

import com.udacity.jwdnd.c1.model.ChatForm;
import com.udacity.jwdnd.c1.model.ChatMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> messages;
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating Message Service Bean");
        this.messages=new ArrayList<>();
    }
    public void addMessage(ChatForm chatForm){
    ChatMessage newMessage=new ChatMessage();
    newMessage.setUsername(chatForm.getUsername());
    switch (chatForm.getMessageType()){
        case "Say":
            newMessage.setMessageText(chatForm.getMessageText());
            break;
        case "Shout":
            newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
            break;
        case "Whisper":
            newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
            break;
    }
    this.messages.add(newMessage);
    }
    public List<ChatMessage> getMessages(){
        return new ArrayList<>(this.messages);
    }
//    private String message;
//    public  MessageService(String message){
//        this.message=message;
//    }
//
//    public String upperCaseMessage(){
//        return this.message.toUpperCase();
//    }
//    public String lowerCaseMessage(){
//        return this.message.toLowerCase();
//    }
//    @PostConstruct
//    public void postConstruct(){
//        System.out.println("Creating MessageService Bean");
//    }
}
