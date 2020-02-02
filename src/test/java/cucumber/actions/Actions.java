package cucumber.actions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.pageobjects.PageObjects;

public class Actions {

	/**
	 * Metodo para abrir browser. Ex: 'Firefox' = Abrir com Firefox | 'Chrome' =
	 * Abrir com Chrome
	 * 
	 * @param browser
	 * @param url
	 * @return
	 * @throws IOException
	 */

	public static WebDriver abrirSite(String browser, String url) throws IOException {
		WebDriver driver;

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.get(url);
		driver.manage().window().maximize();

		return driver;
	}

	public static void InputLados(WebDriver driver, int lado1, int lado2, int lado3) throws InterruptedException {

		if (lado1 == 0 | lado2 == 0 | lado3 == 0) {

			fail("Execução errada, o triangulo não deve possuir lado com valor 0");
		} else {

			PageObjects objects = new PageObjects(driver);
			objects.lado1().clear();
			objects.lado1().sendKeys(String.valueOf(lado1));
			Thread.sleep(1000);
			objects.lado2().clear();
			objects.lado2().sendKeys(String.valueOf(lado2));
			Thread.sleep(1000);
			objects.lado3().clear();
			objects.lado3().sendKeys(String.valueOf(lado3));
			Thread.sleep(1000);

		}
	}

	public static void ValidarResultado(WebDriver driver) throws InterruptedException {

		PageObjects objects = new PageObjects(driver);
		
		System.out.println(objects.lado1().getAttribute("value"));
		System.out.println(objects.lado2().getAttribute("value"));
		System.out.println(objects.lado3().getAttribute("value"));
		int txtlado1 = Integer.valueOf(objects.lado1().getAttribute("value"));
		int txtlado2 = Integer.valueOf(objects.lado2().getAttribute("value"));
		int txtlado3 = Integer.valueOf(objects.lado3().getAttribute("value"));
		objects.calcular().click();
		Thread.sleep(2000);
		String resultado = objects.message().getText().toString();

		if (txtlado1 == txtlado2 && txtlado1 == txtlado3) {
			assertTrue("Falha, esperado triangulo equilatero, resultado atual: " + resultado,
					resultado.contains("Equilátero"));
		}

		else if (txtlado1 != txtlado2 && txtlado1 != txtlado3 && txtlado2 != txtlado3) {
			assertTrue("Falha, esperado triangulo escaleno, resultado atual: " + resultado,
					resultado.contains("Escaleno"));
		}

		else {
			assertTrue("Falha, esperado triangulo isosceles, resultado atual: " + resultado,
					resultado.contains("Isósceles"));

		}
	}
}
