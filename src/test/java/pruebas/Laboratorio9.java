package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9 {
	String url = "https://demo.guru99.com/test/table.html";
	String firefoxDriverPath= "..\\CursoAutomation1\\Drivers\\geckodriver.exe"; 
	WebDriver driver; 
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		driver= new FirefoxDriver();
		driver.get(url);
	}
	
	@Test
	public void leerValoresTabla() {
		System.out.println("Valor de fila 1, columna 3: " + driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText());
		System.out.println("Valor de fila 3, columna 2: " + driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText());
		System.out.println("Valor de fila 4, columna 3: "+ driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
	}
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}
}
