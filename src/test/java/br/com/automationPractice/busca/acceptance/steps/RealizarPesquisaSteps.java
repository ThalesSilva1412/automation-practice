package br.com.automationPractice.busca.acceptance.steps;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.automationPractice.util.Driver;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RealizarPesquisaSteps {
	
	private WebDriver browser = new Driver().getDriver();
	private String url = "http://automationpractice.com/index.php";
	
	@Dado("^que eu esteja na pagina inicial$")
	public void que_eu_esteja_na_pagina_inicial() {
		browser.get(url);
	}

	@Quando("^eu coloco infornacoes validas$")
	public void eu_coloco_infornacoes_validas(List<String> arg1) {
		browser.findElement(By.id("search_query_top")).sendKeys(arg1.get(0));
		browser.findElement(By.name("submit_search")).click();
	}

	@Entao("^minha busca e realizada$")
	public void minha_busca_e_realizada() {
		assertTrue(browser.getCurrentUrl().contains("search_query=Dress"));
		String texto = browser.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
		System.out.println(texto);
		assertTrue(texto.equals("\"DRESS\""));
		browser.quit();
	}

	@Quando("^eu coloco a \"([^\"]*)\" invalidas$")
	public void eu_coloco_a_invalidas(String arg1) {
		browser.findElement(By.id("search_query_top")).sendKeys(arg1);
		browser.findElement(By.name("submit_search")).click();
	}

	@Entao("^minha busca nao e realizada e uma mensagem de erro aparece$")
	public void minha_busca_nao_e_realizada_e_uma_mensagem_de_erro_aparece(List<String> arg1) {
		assertFalse(browser.getCurrentUrl().equals(url));
		String texto = browser.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		assertTrue(texto.contains(arg1.get(0)));
		browser.quit();
	}

}
