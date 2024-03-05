package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaContacto {
	
	//Elementos
	@FindBy(id="input-name")
	WebElement inputName;
	@FindBy(css="input[name=email]")
	WebElement inputEmail;
	@FindBy(css="textarea[name=enquiry]")
	WebElement inputEnquiry;
	
	@FindBy(css="input[value='Submit']")
	WebElement btnSubmit;
	
	//Constructor
	public PaginaContacto(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones
	public void mandarContacto(String nombre,String email,String consulta) {
		inputName.clear();
		inputName.sendKeys(nombre);
		inputEmail.clear();
		inputEmail.sendKeys(email);
		inputEnquiry.sendKeys(consulta);
		btnSubmit.click();
	}

}
