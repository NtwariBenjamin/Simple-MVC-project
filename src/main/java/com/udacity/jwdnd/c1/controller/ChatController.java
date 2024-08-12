package com.udacity.jwdnd.c1.controller;

import com.udacity.jwdnd.c1.model.ChatForm;
import com.udacity.jwdnd.c1.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/chat")
    public String addMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("greetings", this.messageService.getMessages());

        return "chat";
    }
    @GetMapping("/chat")
    public String home(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("greetings",this.messageService.getMessages());
        return "chat";
    }
    @ModelAttribute("allMessageTypes")
    public String modelAttribute(Model model){
        model.addAttribute("allMessageTypes", new String[]{"Say","Shout","Whisper"});
        return "Chat";
    }
}