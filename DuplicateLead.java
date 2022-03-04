
/*http://leaftaps.com/opentaps/control/main
 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)
		
		*/
package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("testemail@test.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
//to store the details of first lead of search
		WebElement firstNameElement = driver.findElement(By.xpath
				("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		String firstNameText = firstNameElement.getText();
		firstNameElement.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		//driver.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[1]")).click();
		String titlePage = driver.getTitle();
		System.out.println(titlePage);
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String firstNameRecheck = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		boolean nameCheck = firstNameText.equals(firstNameRecheck);
		if(nameCheck)
		{
			System.out.println("First Names of leads are same");
		}
		else
			System.out.println("First names of lead are different");
		
	}

}
