package com.udacity.jwdnd.c1;

import com.udacity.jwdnd.c1.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id = "messageText")
    private WebElement textField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;
    @FindBy(className= "chatMessageUsername")
    private WebElement firstMessageUsername;
    @FindBy(className= "chatMessageText")
    private WebElement firstMessageText;
    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
   public void sendChatMessage(String text){
        this.textField.sendKeys(text);
        this.submitButton.click();
   }
    public ChatMessage getFirstMessage(){
        ChatMessage result=new ChatMessage();
        result.setUsername(firstMessageUsername.getText());
        result.setMessageText(firstMessageText.getText());
        return result;
    }
}
