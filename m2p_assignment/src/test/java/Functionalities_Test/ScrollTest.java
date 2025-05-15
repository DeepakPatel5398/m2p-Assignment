package Functionalities_Test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Long scrollBefore = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println("Scroll position before scroll: " + scrollBefore);

		
		 js.executeScript("window.scrollBy(0,700)");
		 
		 Long scrollAfter = (Long) js.executeScript("return window.pageYOffset;");
		System.out.println("scroll position after scroll : "+ scrollAfter);
	}

}
