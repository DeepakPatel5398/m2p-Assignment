package Functionalities_Test;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuWindowHandle {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		@Nullable
		String currentChildWindow = driver.getCurrentUrl();
		String expectedTab="https://the-internet.herokuapp.com/windows/new";
		
		for(String new_window: childWindows) {
			driver.switchTo().window(new_window);
			if(currentChildWindow.equals(expectedTab)) {
				break;
			}
		}
		
		String expectedTitle="New Window";
	   if(driver.getTitle().equals(expectedTitle)) {
		   System.out.println("Title matched");
	   }else {
		   System.out.println("Title not matched");
	   }
	}

}
