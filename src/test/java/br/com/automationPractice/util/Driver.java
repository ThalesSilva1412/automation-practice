package br.com.automationPractice.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private WebDriver driver;
	
	public void iniciarDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		iniciarDriver();
		return this.driver;
	}
	
}
