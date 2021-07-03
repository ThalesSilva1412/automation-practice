package br.com.automationPractice.carrinho.acceptance.steps;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.automationPractice.util.Driver;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class UsandoCarrinhoSteps {
	
	private WebDriver browser = new Driver().getDriver();
	private String url = "http://automationpractice.com/index.php";
	
	@Dado("^que eu esteja logado$")
	public void que_eu_esteja_logado(List<String> valores) {
		browser.get(url);
		browser.findElement(By.className("login")).click();
		colocarValoresESubmeter(valores);
	}

	@Quando("^pesquisar um produto$")
	public void pesquisar_um_produto(List<String> arg1) {
		pesquisarProduto(arg1.get(0));
	}

	@Quando("^vizualizo ele$")
	public void vizualizo_ele() {
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
	}

	@Quando("^coloco ele no carrinho$")
	public void coloco_ele_no_carrinho() {
		browser.findElement(By.id("add_to_cart")).click();
	}

	@Entao("^o carrinho recebera o produto$")
	public void o_carrinho_recebera_o_produto() {
		browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
		Integer produtos = browser.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody")).size();
		assertFalse(produtos.equals(0));
		browser.quit();
	}
	
	@Dado("^com um produto no carrinho$")
	public void com_um_produto_no_carrinho(List<String> arg1) {
		pesquisarProduto(arg1.get(0));
		browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
		browser.findElement(By.id("add_to_cart")).click();
	}

	@Quando("^eu tento remover o produto$")
	public void eu_tento_remover_o_produto() {
		browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
		browser.findElement(By.className("cart_quantity_delete")).click();
	}

	@Entao("^o carrinho fica vazio$")
	public void o_carrinho_fica_vazio() {
		Integer produtos = browser.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody")).size();
		assertTrue(produtos.equals(0));
		browser.quit();
	}
	
	public void colocarValoresESubmeter(List<String> valores) {
		browser.findElement(By.id("email")).sendKeys(valores.get(0));
		browser.findElement(By.id("passwd")).sendKeys(valores.get(1));
		browser.findElement(By.id("SubmitLogin")).click();	
	}
	
	public void pesquisarProduto(String prod) {
		browser.findElement(By.id("search_query_top")).sendKeys(prod);
		browser.findElement(By.name("submit_search")).click();
	}

}
