package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HomePage {
	
	WebDriver driver;
	

@Given("user enters the login page")
public void user_enters_the_login_page() {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get("https://demo.actitime.com/login.do");
	   driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
}
	
@When("user enters the \"(.*)\" and \"(.*)\"$")
public void user_enters_the_and(String userName, String passWord) {
	driver.findElement(By.id("username")).sendKeys(userName);
	driver.findElement(By.name("pwd")).sendKeys(passWord);
	driver.findElement(By.id("loginButton")).click();
}

	@When("homepage is displayed")
	public void homepage_is_displayed() throws InterruptedException {
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		//Assert.assertEquals("acti[TIME - Login]", title);
	}

	@Then("user clicks on tasks page")
	public void user_clicks_on_tasks_page()
	{
		driver.findElement(By.id("container_tasks")).click();
		
	}
	
	@Then("user clicks on add customer")
	public void user_clicks_on_add_customer() {
	    driver.findElement(By.xpath("//div[contains(@class,'title ellipsis')]")).click();
	}
	
	@Then("user clicks on new customer")
	public void user_clicks_on_new_customer() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(@class,'item createNewCustomer')]")).click();
//		Actions act= new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'item createNewCustomer')]"))).build().perform();
		Thread.sleep(3000);
	}
	
	@Then("user creates new \"(.*)\"$")
	public void user_creates_new_customer(String customerName) throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(@class,'customerNameDiv')]//input[contains(@placeholder,'Enter Customer Name')]")).sendKeys(customerName);
		driver.findElement(By.xpath("//div[contains(@class,'emptySelection')]")).click();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='searchItemList']//div[contains(text(),'testing')]"));
		int count=list.size();
		System.out.println(count);
		driver.findElement(By.xpath("//div[@class='components_button_label']//parent::div[@class='components_button withPlusIcon']")).click();
		Thread.sleep(3000);
	}

//	@Then("user clicks on report page")
//	public void user_clicks_on_report_page()
//	{
//		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
//	}
	
	@Then("^user closes the browser$")
	public void user_closes_the_browser()
	{
		driver.quit();
	}




}
