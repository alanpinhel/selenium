package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {
	private WebDriver driver;
	private LeiloesPage leiloes;
	private UsuariosPage usuarios;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Alan Pinhel/Downloads/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get(new URLDaAplicacao().getUrlBase() + "/apenas-teste/limpa");
		
		leiloes = new LeiloesPage(driver);
		usuarios = new UsuariosPage(driver);
		
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@paulo.com");
		
		leiloes.visita();
	}
	
	@After
	public void finish() {
		driver.close();
	}
	
	@Test
	public void deveCadastrarUmLeilao() {
		leiloes.novo().cadastra("Geladeira", 123.00, "Paulo Henrique", true);
		
		Assert.assertTrue(leiloes.existe("Geladeira", 123.00, "Paulo Henrique", true));
	}
	
	@Test
	public void naoDeveCadastrarUmLeilaoSemNomeOuSemValor() {
		NovoLeilaoPage novoLeilao = leiloes.novo();
		
		novoLeilao.cadastra("", 0.00, "Paulo Henrique", true);
		
		Assert.assertTrue(novoLeilao.validacaoDeNomeObrigatorio());
		Assert.assertTrue(novoLeilao.validacaoDeValorObrigatorio());
	}
}