package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;

import org.testng.annotations.DataProvider;


import paginas.PaginaHome;
import paginas.PaginaLogin;

public class Laboratorio8 {
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
	
	@Test (description = "CP01 - Loguearse en pagina", priority= 1, dataProvider="Datos login Excel")
	public void login(String email, String password) {
		//Clic en sign in
		PaginaHome pHome = new PaginaHome(driver);
		pHome.hacerClicEnLogin();
		//Completar las credenciales para iniciar sesión
		PaginaLogin pLogin = new PaginaLogin(driver);
		pLogin.escribirEmail(email);
		pLogin.escribirContraseña(password);
		pLogin.hacerClicEnLogin();		
		String tituloEsperado = "My Account"; //head>title
		String tituloActual = driver.getTitle();
		Assert.assertEquals(tituloEsperado,tituloActual);
	}
	
	@DataProvider(name="Datos login Excel")
	public Object[][] obtenerDatosExcel() throws Exception{
		return DatosExcel.leerExcel("..\\CursoAutomation1\\Datos\\ExcelDataProvider.xlsx","Hoja1");
	}
	
	@DataProvider (name="Datos Login")	
	public Object[][] obtenerDatos(){
		Object[][] datos = new Object[3][2]; //3 sets de datos para probar el login 
		
		datos[0][0] = "abc@gmail.com";
		datos[0][1] = "aaaaa";
		
		datos[1][0] = "tst@gmail.com";
		datos[1][1] = "bbbbbbbb";
		
		datos[2][0] = "ggggg@hotmail.com";
		datos[2][1] = "nnnnnnn";
		
		return datos;
	}
}
