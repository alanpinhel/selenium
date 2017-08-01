package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeiloesPage {
	private WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
        driver.get(new URLDaAplicacao().getUrlBase() + "/leiloes");
    }
	
	public NovoLeilaoPage novo() {
		 driver.findElement(By.linkText("Novo Leilão")).click();
		 return new NovoLeilaoPage(driver);
    }
	
	public DetalhesDoLeilaoPage detalhes(int posicao) {
		driver.findElements(By.linkText("exibir")).get(posicao-1).click();
		return new DetalhesDoLeilaoPage(driver);
	}
	
	public boolean existe(String nome, Double valor, String usuario, Boolean usado) {
		Boolean temLeilao = 
			new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("table"), nome));
		
		if (temLeilao) {
			return driver.getPageSource().contains(nome)
				&& driver.getPageSource().contains(String.valueOf(valor))
				&& driver.getPageSource().contains(usuario)
				&& driver.getPageSource().contains(usado ? "Sim" : "Não");
		}
		
		return false;
	}
}