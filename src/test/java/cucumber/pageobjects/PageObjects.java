package cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObjects {

	public WebDriver driver;

	@FindBy(id = "lado1")
	WebElement lado1;

	@FindBy(id = "lado2")
	WebElement lado2;
	
	@FindBy(id = "lado3")
	WebElement lado3;
	
	@FindBy(id = "calcular")
	WebElement calcular;
	
	@FindBy(id = "message")
	WebElement message;

	public PageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		}

		public WebElement lado1() {
			return (lado1);
		}

		public WebElement lado2() {
			return (lado2);
		}

		public WebElement lado3() {
			return (lado3);
		}

		public WebElement calcular() {
			return (calcular);
		}
		
		public WebElement message() {
			return (message);
		}
	}