package Edit.CursoAutomation1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//Para las esperas:
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Laboratorio2 {	
	String url= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String chromeDriverPath = "..\\CursoAutomation1\\Drivers\\chromedriver.exe"; //-->Se recomienda escribirlo como ruta relativa y NO ABSOLUTA
	String geckoDriverPath = "..\\CursoAutomation1\\Drivers\\geckodriver.exe";
	

	@Test
	public void buscarPalabraEnChrome(){
		//Paso 1: Indicar donde está el driver.exe
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		//Paso 2:Abrir el navegador Chrome en la URL que voy a probar
		
		WebDriver driver = new ChromeDriver(); //Creo navegador indicando Chrome 
		driver.get(url); //.get -> Permite cargar una pagina web en el navegador indicado
		
		//Paso 3:Escribir la palabra que quiero buscar
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement usernameInput = mywait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));

        usernameInput.sendKeys("prueba");

		//Paso 4:Simular que presiono la letra enter en mi teclado
        usernameInput.sendKeys(Keys.ENTER);
		
		//Paso 5: Cerrar el navegador
		//driver.quit();
	
	}		
		@Test
		public void buscarPalabraEnFirefox(){
			System.setProperty("webdriver.gecko.driver",chromeDriverPath);
			WebDriver driver = new FirefoxDriver(); 
			driver.get(url); 

		
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement usernameInput = mywait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));

	        usernameInput.sendKeys("prueba");
	        usernameInput.sendKeys(Keys.ENTER);
			driver.quit();
	}

}
