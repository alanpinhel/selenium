package test;

import org.openqa.selenium.WebDriver;

class CriadorDeCenarios {
	private WebDriver driver;

	public CriadorDeCenarios(WebDriver driver) {
		this.driver = driver;
	}

	public CriadorDeCenarios umUsuario(String nome, String email) {
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra(nome, email);

		return this;
	}

	public CriadorDeCenarios umLeilao(String usuario, String produto, double valor, boolean usado) {
		LeiloesPage leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().cadastra(produto, valor, usuario, usado);

		return this;
	}
}