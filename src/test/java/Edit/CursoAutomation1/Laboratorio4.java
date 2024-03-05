package Edit.CursoAutomation1;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio4 {

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String chromeDriverPath = "..\\CursoAutomation1\\Drivers\\chromedriver.exe"; 
	String firefoxDriverPath = "..\\CursoAutomation1\\Drivers\\geckodriver.exe";
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to(url); //abre el navegador en la pagina indicada, funciona igual que el .get()
		driver.manage().window().maximize();
		
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Espera explicita con un tiempo maximo y una condicion de salida.
	    wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
	
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
	}
}
	
