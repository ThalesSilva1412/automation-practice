package br.com.automationPractice.login.acceptance.steps;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.automationPractice.util.Driver;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class acessarContaSteps {
	
	private WebDriver browser = new Driver().getDriver();
	private String url = "http://automationpractice.com/index.php";
	
	@Dado("^que eu esteja na pagina de home$")
	public void que_eu_esteja_na_pagina_de_home() {
		browser.get(url);
	}

	@Quando("^eu tento acessar minha conta$")
	public void eu_tento_acessar_minha_conta() {
		browser.findElement(By.className("login")).click();
	}

	@Quando("^tenha os dados validos$")
	public void tenha_os_dados_validos(List<String> arg1) {
		colocarValoresESubmeter(arg1);
	}

	@Entao("^eu me logo na minha conta$")
	public void eu_me_logo_na_minha_conta() {
		//http://automationpractice.com/index.php?controller=my-account
		assertEquals("http://automationpractice.com/index.php?controller=my-account", browser.getCurrentUrl());
		browser.quit();	
	} 

	@Quando("^possuo dados invalidos$")
	public void possuo_dados_invalidos(List<String> arg1) {
		colocarValoresESubmeter(arg1);
	}
	
	@Entao("^eu nao consigo me logar$")
	public void eu_nao_consigo_me_logar() {
		assertTrue(browser.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication"));
	}
	

	@Entao("^uma mensagem de erro aparece$")
	public void uma_mensagem_de_erro_aparece(List<String> arg1) {
		List<WebElement> alerta = browser.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
		assertEquals(arg1.get(0), alerta.get(0).getText());
		browser.quit();
	}
	
	public void colocarValoresESubmeter(List<String> valores) {
		browser.findElement(By.id("email")).sendKeys(valores.get(0));
		browser.findElement(By.id("passwd")).sendKeys(valores.get(1));
		browser.findElement(By.id("SubmitLogin")).click();	
	}
}
