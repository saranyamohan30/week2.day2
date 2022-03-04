//http://leafground.com/pages/Edit.html

package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testemail@test.com");
		WebElement appendVerify = driver.findElement(By.xpath("(//label[@for='email']/following-sibling::input)[2]"));
		appendVerify.sendKeys("Add text");
		appendVerify.sendKeys(Keys.TAB);
		//appendVerify.sendKeys(Keys.EQUALS);
		appendVerify.sendKeys(Keys.ENTER);
		String textExists = driver.findElement(By.xpath("(//input[@name='username'])[1]")).getAttribute("value");
		/*
		 * WebElement textEntered =
		 * driver.findElement(By.xpath("//input[@name='username']")); String textExist =
		 * textEntered.getAttribute("value");
		 */
		System.out.println(textExists);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		boolean enabled = driver.findElement(By.xpath("//label[@for='disabled']/following-sibling::input")).isEnabled();
		if(enabled)
		{
			System.out.println("It is enabled");
		}else
			System.out.println("It is disabled");
	}

}
