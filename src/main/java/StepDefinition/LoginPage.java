package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginPage {
	WebDriver driver;

	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();

	}

	@When("^title of login page is actitime$")
	public void title_of_login_page_is_actitime() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("actiTIME - Login", title);
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String userName,String passWord) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.name("pwd")).sendKeys(passWord);
	}

	@Then("user clicks on login")
	public void user_clicks_on_login() {
		driver.findElement(By.id("loginButton")).click();
	
	}
	
	
}
