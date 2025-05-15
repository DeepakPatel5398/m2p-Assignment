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
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		  
        driver.switchTo().frame("frame1");
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println(heading.getText());
        String headingexpectedText="This is a sample page";
        if(heading.getText().contains(headingexpectedText)) {
        	System.out.println("heading matched");
        }else {
        	System.out.println("heading not matched");
        }
        
	}

}
