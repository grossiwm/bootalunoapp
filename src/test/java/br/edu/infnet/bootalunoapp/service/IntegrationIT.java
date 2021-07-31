package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class IntegrationIT {

	
	
	@Test
	public void deveriaCadastrarUmNovoAluno() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/gabrielrossi/Downloads/geckodriver");
		
		WebDriver driver = new SafariDriver();
		driver.get("http://localhost:8484/bootaluno");
		driver.findElement(  By.linkText("Cadastrar novo aluno")).click();
		
		driver.findElement( By.id("nome") ).sendKeys("Antonio");
		driver.findElement( By.id("email") ).sendKeys("antonio@gmail.com");
		
		driver.findElement( By.cssSelector(".btn-primary") ).click();
		
		assertTrue( driver.getPageSource().contains("severino@gmail.com")  );
		
		driver.close();
		
		
	}
	
	@Test
	public void deveriaDeletarUmAluno() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/gabrielrossi/Downloads/geckodriver");
		
		WebDriver driver = new SafariDriver();
		driver.get("http://localhost:8484/bootaluno");
		int numAl = driver.findElements(By.tagName("tr")).size();
	
		driver.findElement(By.cssSelector(".btn-danger")).click();
		
		
		assertTrue( driver.findElements(By.tagName("tr")).size()==numAl-1);
		
		driver.close();
		
		
	}

}
