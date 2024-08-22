package com.udacity.jwdnd.c1;

import com.udacity.jwdnd.c1.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class C1ApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	public String baseURL;
	private ChatPage chatPage;
	private LoginPage loginPage;
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver=null;
	}
	@BeforeEach
	public void beforeEach(){
		baseURL="http://localhost:"+port;
	}
	@Test
	public void testUserSignupLoginAndSubmitMessage(){
		String username="Ben";
		String password="ben";
		String messageText="Hello World!";
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get(baseURL+"/signup");
		SignupPage signupPage=new SignupPage(driver);
		signupPage.signup("Benjamin","Ntwari",username,password);

		driver.get(baseURL+"/login");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(username,password);

		ChatPage chatPage=new ChatPage(driver);
		chatPage.sendChatMessage(messageText);

			ChatMessage sentMessage=chatPage.getFirstMessage();
			assertEquals(username,sentMessage.getUsername());
			assertEquals(messageText,sentMessage.getMessageText());


	}
}
