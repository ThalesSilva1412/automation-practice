package br.com.automationPractice.carrinho.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:br/com/automationPractice/carrinho/features/usandoCarrinho.feature")
public class UsandoCarrinhoRunner {

}
