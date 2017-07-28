package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NovoUsuarioPage {
	private WebDriver driver;

	public NovoUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	public void cadastra(String nome, String email) {
		driver.findElement(By.name("usuario.nome")).sendKeys(nome);
		driver.findElement(By.name("usuario.email")).sendKeys(email);
		driver.findElement(By.id("btnSalvar")).click();
	}
	
	public boolean validacaoDeNomeObrigatorio() {
		return driver.getPageSource().contains("Nome obrigatorio!");
	}
	
	public boolean validacaoDeEmailObrigatorio() {
		return driver.getPageSource().contains("E-mail obrigatorio!");
	}
}