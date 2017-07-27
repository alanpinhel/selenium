package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Alan Pinhel/Downloads/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/Users/Alan Pinhel/Downloads/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.bing.com.br");
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
		
		campoDeTexto.submit();
	}
}