package Functionalities_Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class UserRegistrationPage {
	
		WebDriver driver;
		
		
		@DataProvider(name = "getData")
		public  Object[][] getData() throws EncryptedDocumentException, IOException {
			DataExtractor dt=new DataExtractor();
			Object[][] data = dt.getdatafromexcel();
			return data;
		}
		
		
		@BeforeMethod(alwaysRun = true)
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		}
		
		
		@Test(dataProvider = "getData")
		public void userRegistrationProcess(String fname, String lname, String email, String pass, String cpass) throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement genderLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gender-male']")));
			genderLabel.click();
			WebElement firstName=driver.findElement(By.cssSelector("#FirstName"));      
			WebElement lastName=driver.findElement(By.cssSelector("#LastName"));       
			WebElement enterEmail=driver.findElement(By.cssSelector("#Email"));       	
			WebElement password=driver.findElement(By.cssSelector("#Password"));        
			WebElement confirmpassword=driver.findElement(By.cssSelector("#ConfirmPassword"));    
			WebElement registerButton=driver.findElement(By.cssSelector("#register-button")); 
			
			
			
			firstName.sendKeys(fname);
			lastName.sendKeys(lname);
			enterEmail.sendKeys(email);
			password.sendKeys(pass);
			confirmpassword.sendKeys(cpass);
			registerButton.click();
			
		}
		
		
		@AfterMethod
		public void teardown() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}
		
		
	
		
	
		
	

}
