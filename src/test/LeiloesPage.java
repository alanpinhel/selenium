package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeiloesPage {
	private WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
        driver.get("http://localhost:8080/leiloes");
    }
	
	 public NovoLeilaoPage novo() {
		 driver.findElement(By.linkText("Novo Leilão")).click();
		 return new NovoLeilaoPage(driver);
    }
	
	public boolean existe(String nome, Double valor, String usuario, Boolean usado) {
		return driver.getPageSource().contains(nome)
			&& driver.getPageSource().contains(String.valueOf(valor))
			&& driver.getPageSource().contains(usuario)
			&& driver.getPageSource().contains(usado ? "Sim" : "Não");
	}
}