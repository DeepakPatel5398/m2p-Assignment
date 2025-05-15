package Functionalities_Test;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidatePageTitle {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		@Nullable
		String titleofthepage = driver.getTitle();
		String expectedPageTitle="Selenium";
		
		if(expectedPageTitle.equals(titleofthepage)) {
			System.out.println("Title matched");
		}else {
			System.out.println("Title not matched");
		}
		
		
		WebElement downloadLink = driver.findElement(By.xpath("(//a[@class='nav-link'])[1]"));
		downloadLink.click();
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		String endPoints="/downloads";
		if(currentUrl.contains(endPoints)) {
			System.out.println(endPoints+" is present in the "+ currentUrl);
		}else {
			System.out.println(endPoints+" is not present in the "+ currentUrl);
		}
	}

}
