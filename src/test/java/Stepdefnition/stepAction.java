package Stepdefnition;

import org.openqa.selenium.WebDriver;
import Hooks.Pretest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepAction {
	
	WebDriver driver=Pretest.driver;
	
@Given("Lanuch chrome browser")	
public void launchbrower()
{
	driver.get("https://www.linkedin.com");
		}
	
@When("Navigate to linkedin.com")	 
public void Navigatelinkedin()
{
	System.out.println("Naviagate to home page");
		
	}
@When("Click on SignIn button")	
public void clicksignin(){
	System.out.println("clickonsignin");
	
}
@Then("I validate the outcomes")
public void Result(){
	System.out.println("Validate result");
	
}
}




