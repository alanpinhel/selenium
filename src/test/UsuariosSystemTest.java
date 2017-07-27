package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
    @Test
    public void deveAdicionarUmUsuario() throws InterruptedException {
    	System.setProperty("webdriver.gecko.driver", "C:/Users/Alan Pinhel/Downloads/geckodriver.exe");
    	
    	WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/usuarios/new");

        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));

        nome.sendKeys("Ronaldo Luiz de Albuquerque");
        email.sendKeys("ronaldo2009@terra.com.br");
        nome.submit();

        Thread.sleep(500);
        
        boolean achouNome = driver.getPageSource()
            .contains("Ronaldo Luiz de Albuquerque");
        boolean achouEmail = driver.getPageSource()
            .contains("ronaldo2009@terra.com.br");

        assertTrue(achouNome);
        assertTrue(achouEmail);

        driver.close();
    }
}