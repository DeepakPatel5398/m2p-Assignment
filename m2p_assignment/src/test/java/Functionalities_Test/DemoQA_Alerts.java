package Functionalities_Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQA_Alerts {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert alert1 = driver.switchTo().alert();
		String expectedText="You clicked a button";
		if(alert1.getText().equals(expectedText)) {
			System.out.println("Alert text : "+" ' "+ alert1.getText()+ " ' "+" matched .");
		}else {
			System.out.println("Alert text : "+ " ' "+ alert1.getText()+ " ' "+" doesnot matched .");
		}
	}

}
