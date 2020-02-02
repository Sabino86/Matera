package cucumber.teste;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.actions.Actions;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepsDefinition {

	WebDriver driver;
		
	@Given("^estar na pagina de preenchimento$")
	public void estar_na_pagina_de_preenchimento() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver = Actions.abrirSite("Firefox", "https://calculadoratriangulo.herokuapp.com/");
	}

	@When("^preencher os (\\d+) e (\\d+) e (\\d+)$")
	public void preencher_os_e_e(int lado1, int lado2, int lado3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Actions.InputLados(driver, lado1, lado2, lado3);
	}
	
	@Then("^o sistema verifica o resultado$")
	public void o_sistema_verifica_o_resultado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Actions.ValidarResultado(driver);
	
	}
	
	@After
	public void fecharBrowser() {
		
		driver.close();
		
	}

}