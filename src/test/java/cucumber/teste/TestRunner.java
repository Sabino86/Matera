package cucumber.teste;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue="cucumber.teste")
public class TestRunner {

/*@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", 
glue = "cucumber.teste.StepsDefinition", monochrome = true, dryRun = false)
public class TestRunner {*/
}