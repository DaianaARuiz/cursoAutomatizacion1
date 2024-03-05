package Edit.CursoAutomation1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public final class Laboratorio7 {
	String url = "https://demoqa.com/alerts";
	String firefoxDriverPath= "..\\CursoAutomation1\\Drivers\\chromedriver.exe"; 
	WebDriver driver; 
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
		driver = new ChromeDriver();  
		driver.navigate().to(url);
		driver.manage().window().maximize(); 
	}
	
	@Test 
	public void alertaNotificacion() {
		driver.findElement(By.id("alertButton")).click();
		
		//Tomamos control de la alerta para hacer click en aceptar. 
		Alert alert = driver.switchTo().alert(); 
		
		String texto = alert.getText(); //obtiene el texto que contiene la alerta. 
		System.out.println(texto);
		alert.accept(); //hacemos click en la opcion aceptar
		}
	
	@Test 
	public void alertaEspera() {
		driver.findElement(By.id("timerAlertButton")).click();
		//Agrego una espera de 10s o hasta que la espera aparezca
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept(); 
		}
	
	@Test 
	public void alertaCancelar() {
		driver.findElement(By.cssSelector("#confirmButton")).click();
		driver.switchTo().alert().dismiss(); 
		}
	
	
	@Test 
	public void alertaTexto() {
		driver.findElement(By.cssSelector("#confirmButton")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Ejemplo");
		alerta.accept();
		}



}
