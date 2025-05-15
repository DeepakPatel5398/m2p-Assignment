package Functionalities_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQA_Frames {
	public static void main(String[] args) {

		// chrome broswer driver setup 
		WebDriverManager.chromedriver().setup();

		//launching chrome browser
		WebDriver driver=new ChromeDriver();

		// maximize the browser screen
		driver.manage().window().maximize();

		// entering url
		driver.get("https://demoqa.com/frames");

		// implicit wait of 9sec 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		// typecaste javascriptexecutor with driver instance sothat v can use javascript method with driver instances
		JavascriptExecutor js=(JavascriptExecutor)driver;

		//scrolling 300 pixels
		js.executeScript("window.scrollBy(0,300)");
		
	    // switching to frame
        driver.switchTo().frame("frame1");

		// heading of the frame located by id
        WebElement heading = driver.findElement(By.id("sampleHeading"));

       // Expected heading text 
        String headingexpectedText="This is a sample page";

		// using if-else instedof assurtions so that easily print the outcomdes of result in console
        if(heading.getText().contains(headingexpectedText)) {
        	System.out.println("heading matched");
        }else {
        	System.out.println("heading not matched");
        }
        
	}

}
