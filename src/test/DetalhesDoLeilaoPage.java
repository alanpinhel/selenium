package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {
	private WebDriver driver;

	public DetalhesDoLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void lance(String usuario, Double valor) {
		Select cbUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));
		WebElement txtValor = driver.findElement(By.name("lance.valor"));
		WebElement btnDarLance = driver.findElement(By.id("btnDarLance"));

		cbUsuario.selectByVisibleText(usuario);
		txtValor.sendKeys(String.valueOf(valor));
		btnDarLance.click();
	}

	public boolean existeLance(String usuario, Double valor) {
		Boolean temUsuario = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElementLocated(By.id("lancesDados"), usuario));

		if (temUsuario)
			return driver.getPageSource().contains(usuario) && driver.getPageSource().contains(String.valueOf(valor));

		return false;
	}
}