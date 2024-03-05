package pruebas;

import javax.imageio.ImageIO;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScrollScreenshot {
	WebDriver driver;
	
	@Test
	public void scrollScreenShotTest() throws Exception{
		System.setProperty("webdriver.gecko.driver","..\\CursoAutomation1\\Drivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://www.bbc.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(s.getImage(),"PNG",new File ("..\\CursoAutomation1\\Evidencias\\fullPageScreenShot.png"));
		
		driver.close();
	}
	
}
