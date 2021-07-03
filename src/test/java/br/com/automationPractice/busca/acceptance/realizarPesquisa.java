package br.com.automationPractice.busca.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:br/com/automationPractice/busca/features/realizarPesquisa.feature")
public class realizarPesquisa {

}
