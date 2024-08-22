package com.udacity.jwdnd.c1.service;

import com.udacity.jwdnd.c1.mapper.MessageMapper;
import com.udacity.jwdnd.c1.model.ChatForm;
import com.udacity.jwdnd.c1.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                System.out.println("Say");
                break;
            case "Shout":
                System.out.println(chatForm.getMessageText());

                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                System.out.println("Shout");
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }

        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages(String userName) {
        return messageMapper.getAllMessages(userName);
    }
}
