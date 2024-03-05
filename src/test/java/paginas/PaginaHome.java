package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//https://opencart.abstracta.us
public class PaginaHome {
	
	//Elementos de la pagina 
	@FindBy(linkText = "My Account") 
	WebElement linkMenu;
	
	
	@FindBy(linkText = "Login") 
	WebElement linkLogin;
	
	
	@FindBy(css=".fa.fa-phone")
	WebElement linkContactUs;

		
	//Constructor (inicializa los elementos, permite utilizar los elementos y sus acciones para uso. 
	
	public PaginaHome(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Acciones sobre los elementos de la pagina que voy a utilizar
	public void hacerClicEnLogin() {
		linkMenu.click();
		linkLogin.click();
	}
	
	
	public void hacerClicEnContactUs() {
		linkContactUs.click();
	}
	
}
