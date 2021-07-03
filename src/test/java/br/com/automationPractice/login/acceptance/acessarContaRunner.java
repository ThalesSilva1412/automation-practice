package br.com.automationPractice.login.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:br/com/automationPractice/login/features/acessarConta.feature")
public class acessarContaRunner {

}
