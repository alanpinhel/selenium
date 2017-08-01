package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	private WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Alan Pinhel/Downloads/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get(new URLDaAplicacao().getUrlBase() + "/apenas-teste/limpa");
		
		usuarios = new UsuariosPage(driver);
		usuarios.visita();
	}

	@After
	public void finish() {
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		usuarios.novo().cadastra("Adriano Xavier", "axavier@empresa.com.br");

		assertTrue(usuarios.existeNaListagem("Adriano Xavier", "axavier@empresa.com.br"));
	}

	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {
		NovoUsuarioPage form = usuarios.novo();
		
		form.cadastra("", "axavier@empresa.com.br");
		
		assertTrue(form.validacaoDeNomeObrigatorio());
	}

	@Test
	public void naoDeveAdicionarUmUsuarioSemNomeOuSemEmail() {
		NovoUsuarioPage form = usuarios.novo();
		
		form.cadastra("", "");
		
		assertTrue(form.validacaoDeNomeObrigatorio());
		assertTrue(form.validacaoDeEmailObrigatorio());
	}
	
	@Test
	public void deveExcluirUmUsuario() throws InterruptedException {
		usuarios.novo().cadastra("Stan Smith", "stan@smith.com");
		assertTrue(usuarios.existeNaListagem("Stan Smith", "stan@smith.com"));
		
		usuarios.excluiUsuarioNaPosicao(1);
		
		assertFalse(usuarios.existeNaListagem("Stan Smith", "stan@smith.com"));
	}
	
	@Test
	public void deveAlterarUmUsuario() throws InterruptedException {
		usuarios.novo().cadastra("Stan Smith", "stan@smith.com");
		usuarios.altera(1).para("Smith Stan", "stan@smith.com");
		
		assertFalse(usuarios.existeNaListagem("Stan Smith", "stan@smith.com"));
		assertTrue(usuarios.existeNaListagem("Smith Stan", "stan@smith.com"));
	}
}