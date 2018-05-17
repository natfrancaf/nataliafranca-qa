import static org.junit.Assert.*;
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
	
	@Before
	public void acesso()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Natalia\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://web1.qa.sambatech.com:10000/auth/login");
	}
	
	
	@Test
	public void loginInvalido()
	{
		WebElement entrar = driver.findElement(By.id("login"));
		entrar.click();
		
		WebElement mensagem = driver.findElement(By.id("password_incorrect"));
		assertTrue(mensagem.getText().contains("Email ou senha incorretos. Saiba Mais"));
	}
	
	@Test
	public void login()
	{
		
		WebElement email = driver.findElement(By.id("inputEmail"));
		email.sendKeys("avaliacao_qa_samba@sambatech.com.br");
		
		WebElement senha = driver.findElement(By.id("inputPassword"));
		senha.sendKeys("123456789");
		
		WebElement entrar = driver.findElement(By.id("login"));
		entrar.click();
		
		WebElement abaPainel = driver.findElement(By.id("mn-dashboard"));
		
		assertTrue(abaPainel.getText().contains("Painel"));
				
		
	}
	
	@After
	public void fecharBrowser()
	{
		driver.quit();
	}
	
}
