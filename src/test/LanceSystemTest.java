package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {
	private WebDriver driver;
    private LeiloesPage leiloes;
	
    @Before
    public void setup() {
    	System.setProperty("webdriver.gecko.driver", "C:/Users/Alan Pinhel/Downloads/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get(new URLDaAplicacao().getUrlBase() + "/apenas-teste/limpa");
		
		CriadorDeCenarios criador = new CriadorDeCenarios(driver);
		criador
			.umUsuario("Paulo Henrique", "paulo@henrique.com")
			.umUsuario("Stan Smith", "stan@smith.com")
			.umLeilao("Paulo Henrique", "Geladeira", 400.00, true);
		
		leiloes = new LeiloesPage(driver);
    }
    
    @After
    public void finish() {
    	driver.close();
    }
    
	@Test
	public void deveFazerUmLance() {
		DetalhesDoLeilaoPage detalhe = leiloes.detalhes(1);
		
		detalhe.lance("Stan Smith", 410.00);
		
		Assert.assertTrue(detalhe.existeLance("Stan Smith", 410.00));
	}
}