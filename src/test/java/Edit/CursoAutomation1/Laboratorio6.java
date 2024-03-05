package Edit.CursoAutomation1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio6 {
	String url = "https://way2automation.com/way2auto_jquery/index.php";
	String driverPath = "..\\CursoAutomation1\\Drivers\\chromedriver.exe";
	String dirEvidencias = "..\\CursoAutomation1\\Evidencias\\";
	String nombreDocumento = "Evidencias - Automation Practice.docx";
	String nombreImg = "img.jpg";

	WebDriver driver;
	File screen;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();  
		driver.navigate().to(url);
		driver.manage().window().maximize(); 
	}
	
	@Test (description = "CP01 - Completar formulario", priority= 1)
	public void completarFormulario() throws IOException {
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "01_PaginaPrincipal.jpg"));
		
		driver.findElement(By.name("name")).sendKeys("Admin");
		driver.findElement(By.name("phone")).sendKeys("1123456");
		driver.findElement(By.name("email")).sendKeys("correo" + Math.random() + "@gmail.com");
		Select list = new Select (driver.findElement(By.tagName("select")));
		list.selectByValue("India");
		driver.findElement(By.name("city")).sendKeys("Buenos Aires");
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "02_FormularioLleno.jpg"));

		driver.findElement(By.cssSelector("input[type='submit'].button")).click();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "03_ResultadoObtenido.jpg"));
	}
	
	@Test (description = "CP03 - Completar formulario - con documento de evidencias", priority= 1)
	public void completarFormularioConDocumento() throws IOException, InvalidFormatException, InterruptedException {
		//Capturar pantalla en documento:
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de evidencias", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg , dirEvidencias + nombreDocumento, "Paso 1: Pagina principal");
		driver.findElement(By.name("name")).sendKeys("Admin");
		driver.findElement(By.name("phone")).sendKeys("1123456");
		driver.findElement(By.name("email")).sendKeys("correo" + Math.random() + "@gmail.com");
		Select list = new Select (driver.findElement(By.tagName("select")));
		list.selectByValue("India");
		driver.findElement(By.name("city")).sendKeys("Buenos Aires");	
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg , dirEvidencias + nombreDocumento, "Paso 2: Formulario completo");

		driver.findElement(By.cssSelector("input[type='submit'].button")).click();
		
	}
	
	@Test (description = "CP02 - Ir a Testing Websire ", priority= 2)
	public void Signin() {		
		driver.findElement(By.linkText("ENTER TO THE TESTING WEBSITE")).click();
		//Comprobar que despues de hacer click el titulo cambia 
		String tituloEsperado = "Welcome"; //head>title
		String tituloActual = driver.getTitle();
		Assert.assertEquals(tituloEsperado,tituloActual);
	}
}
