import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.fields.FieldIndexSelector;
import org.opentest4j.*;




public class Login {

	private WebDriver driver;
	
	//Acessar a página
	@Before
	public void acesso()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Natalia\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://web1.qa.sambatech.com:10000/auth/login");
	}
	
	//Teste de login inválido com validação da mensagem
	@Test
	public void loginInvalido()
	{
		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("emailinvalido@sambatech.com.br");
		
		WebElement entrar = driver.findElement(By.id("login"));
		entrar.click();
		
		WebElement mensagem = driver.findElement(By.id("password_incorrect"));
		assertTrue(mensagem.getText().contains("Email ou senha incorretos. Saiba Mais"));
	}
	
	//Teste de login válido
	@Test
	public void login()
	{
		
		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("avaliacao_qa_samba@sambatech.com.br");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		WebElement senha = driver.findElement(By.id("inputPassword"));
		senha.sendKeys("123456789");
		
		WebElement entrar = driver.findElement(By.id("login"));
		entrar.click();
		
		WebElement abaPainel = driver.findElement(By.id("mn-dashboard"));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//WebDriverWait.until(condition-that-finds-the-element);
		assertTrue(abaPainel.getText().contains("Painel"));
				
		
	}
	
	//Fechar o browser após o teste
	@After
	public void fecharBrowser()
	{
		driver.quit();
	}
	
}
