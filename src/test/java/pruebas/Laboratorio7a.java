package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContacto;
import paginas.PaginaHome;
import paginas.PaginaLogin;

public class Laboratorio7a {

	String url = "https://opencart.abstracta.us";
	String firefoxDriverPath= "..\\CursoAutomation1\\Drivers\\geckodriver.exe"; 
	WebDriver driver; 
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test (description = "CP01 - Loguearse en pagina", priority= 1)
	public void login() {
		//Clic en sign in
		PaginaHome pHome = new PaginaHome(driver);
		pHome.hacerClicEnLogin();
		//Completar las credenciales para iniciar sesión
		PaginaLogin pLogin = new PaginaLogin(driver);
		pLogin.escribirEmail("tst@gmail.com");
		pLogin.escribirContraseña("123456789");
		pLogin.hacerClicEnLogin();
		
		
		//Comprobar que despues de hacer click el titulo cambia 
			String tituloEsperado = "My Account"; //head>title
			String tituloActual = driver.getTitle();

			Assert.assertEquals(tituloEsperado,tituloActual);
	}
	
	@Test (description = "CP02 - Enviar consulta", priority= 2)
	public void enviarConsulta() {
		PaginaHome pHome = new PaginaHome(driver);
		pHome.hacerClicEnContactUs();
		PaginaContacto pContacto = new PaginaContacto(driver);
		pContacto.mandarContacto("daiana", "tst@gmail.com", "Mensaje de contacto");
		String urlEsperada = "http://opencart.abstracta.us/index.php?route=information/contact/success";
		String urlObtenida =driver.getCurrentUrl();
		
		Assert.assertEquals(urlEsperada,urlObtenida);
	}
}
