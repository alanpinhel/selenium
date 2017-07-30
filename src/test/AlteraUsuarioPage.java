package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {
	private WebDriver driver;

	public AlteraUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void para(String nome, String email) {
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));
		
		txtNome.clear();
		txtNome.sendKeys(nome);
		
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
		driver.findElement(By.id("btnSalvar")).click();
	}
}