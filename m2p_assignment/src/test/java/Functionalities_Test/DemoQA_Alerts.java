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
		
		// chrome broswer driver setup 
		WebDriverManager.chromedriver().setup();

		// opening chrome browser
		WebDriver driver=new ChromeDriver();

		// maximizing window
		driver.manage().window().maximize();

		// entering url
		driver.get("https://demoqa.com/alerts");

		// applying implicit wait of 9 sec to wait till url loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		
		// typecasting Javascriptexecutor with driver instance ,so that we canuse javascript method to scroll 
		JavascriptExecutor js=(JavascriptExecutor)driver;

		//scrolling till 300 pixels vertically
		js.executeScript("window.scrollBy(0,300)");
		
		// locateing and clicking on simple alert button
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();

		// Using ALert interface and switchTo() to navigate driver to the alert
		Alert alert1 = driver.switchTo().alert();

		// expected alert text 
		String expectedText="You clicked a button";

		// Used if else statement to simply print the result in the console.
		if(alert1.getText().equals(expectedText)) {
			System.out.println("Alert text : "+" ' "+ alert1.getText()+ " ' "+" matched .");
		}else {
			System.out.println("Alert text : "+ " ' "+ alert1.getText()+ " ' "+" doesnot matched .");
		}
	}

}
