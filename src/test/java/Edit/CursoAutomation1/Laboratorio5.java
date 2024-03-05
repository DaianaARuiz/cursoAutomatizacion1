package Edit.CursoAutomation1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio5 {

	String url = "https://way2automation.com/way2auto_jquery/index.php";
	String driverPath = "..\\CursoAutomation1\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver= new ChromeDriver();  
		driver.navigate().to(url);
		driver.manage().window().maximize(); 
	}
	
	@Test (description = "CP01 - Completar formulario", priority= 1)
	public void completarFormulario() {
		driver.findElement(By.name("name")).sendKeys("Admin");
		driver.findElement(By.name("phone")).sendKeys("1123456");
		driver.findElement(By.name("email")).sendKeys("correo" + Math.random() + "@gmail.com");
		Select list = new Select (driver.findElement(By.tagName("select")));
		list.selectByValue("India");
		driver.findElement(By.name("city")).sendKeys("Buenos Aires");
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
