package paginas;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaLogin {
	//Element
	@FindBy(id="input-email")
	WebElement txtEmail;
	@FindBy(id="input-password")
	WebElement txtContraseña;
	@FindBy(css="input[type='submit'][value='Login']")
	WebElement btnLogin;
	
	
	WebDriver driver;
	
	//Constructor:
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	//Acciones
	public void escribirEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		txtEmail.sendKeys(email);
	}
	
	public void escribirContraseña(String contraseña) {
		txtContraseña.sendKeys(contraseña);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void ingresarCredenciales(String email,String contraseña) {
		txtEmail.sendKeys(email);
		txtContraseña.sendKeys(contraseña);
		btnLogin.click();
	}
}
