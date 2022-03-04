// Step 1: Download and set the path 
// Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
 package week2.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateXpath {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Driver\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		//xpath with parent to child : //parent xpath/child tag name
		driver.findElement(By.name("firstname")).sendKeys("sarantest");//first name
		driver.findElement(By.name("lastname")).sendKeys("saranfirst");//surname
		driver.findElement(By.name("reg_email__")).sendKeys("987654321");//Mobile Number
		driver.findElement(By.id("password_step_input")).sendKeys("123456789");//Password 
		//for day
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select dayDropDownObject=new Select(dayDropDown);
		List<WebElement> dayOptions = dayDropDownObject.getOptions();
		//to get all the values in the dropdown
		for(int i=0;i<dayOptions.size();i++) {	
			System.out.println(dayOptions.get(i).getText());
		}
		dayDropDownObject.selectByValue("30");
		
		//for year
		WebElement yearDropDown = driver.findElement(By.id("year"));
		Select yearDropDownObject=new Select(yearDropDown);
		yearDropDownObject.selectByVisibleText("1988");
		//for month
				WebElement monthDropDown = driver.findElement(By.id("month"));
				Select monthDropDownObject=new Select(monthDropDown);
				monthDropDownObject.selectByIndex(8);
		//for gender
		driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//input[@value='1']")).click();
		driver.findElement(By.id("//button[@name='websubmit']")).click();
		//Thread.sleep(3000);

	}

}
