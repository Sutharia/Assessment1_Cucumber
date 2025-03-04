package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import Hooks.Pretest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepAction {

	
	WebDriver driver=Pretest.driver;
	
	@Given("User is on the OpenHRMS page")
	public void User_home_page() {
		driver.get("https://o2.openmrs.org/openmrs/login.htm");
	}
	   

	@When("Enter valid credentials")
	public void enter_valid_credentials() {
		
	        WebElement user = driver.findElement(By.id("username"));
	        user.sendKeys("admin");
	        WebElement pwd = driver.findElement(By.id("password"));
	        pwd.sendKeys("Admin123");
	        WebElement inpatient=driver.findElement(By.xpath("//*[@id=\"Inpatient Ward\"]"));
	        inpatient.click();
	          
	    }
	
	    
	@When("Click on login button")
	public void click_on_login_button() {
		WebElement log=driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
		 log.click();
	}
	

	@Then("User is in inpatient page")
	public void user_is_in_inpatient_page() {
		
		System.out.println("User in inpatient page ");	

	}
	
	
	@Given("User is on Inpatient page")
	public void user_is_on_inpatient_page() {
		driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();
	}
	@And("Selects Register a patient")
	public void selects_register_a_patient() {
		System.out.println("Registeration page loaded");
		}
	
	@When("User Provide Demographic, Contact Info, Relationship details in the details page")
	public void enter_Patient_informations() {
		driver.findElement(By.name("givenName")).sendKeys("Madh");
		driver.findElement(By.name("familyName")).sendKeys("Anuj");
		driver.findElement(By.id("next-button")).click();
	    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement genderDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gender-field")));
		Select selectGender = new Select(genderDropdown);
		selectGender.selectByVisibleText("Male");
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.name("birthdateDay")).sendKeys("25");
		WebElement dropdown = driver.findElement(By.name("birthdateMonth"));
		dropdown.click();
		Select month = new Select(dropdown);
		month.selectByValue("2");
		driver.findElement(By.name("birthdateYear")).sendKeys("1993");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.cssSelector("#address1")).sendKeys("123 Arista tower");
		driver.findElement(By.cssSelector("#address2")).sendKeys("Medows garden");
		driver.findElement(By.id("cityVillage")).sendKeys("Kochi");
		driver.findElement(By.cssSelector("#stateProvince")).sendKeys("Kerala");
		driver.findElement(By.cssSelector("#country")).sendKeys("India");
		driver.findElement(By.cssSelector("#postalCode")).sendKeys("672348");
		driver.findElement(By.cssSelector(".fas.fa-chevron-right")).click();
		
		driver.findElement(By.className("phone")).sendKeys("+911345666887");
		driver.findElement(By.cssSelector("#next-button")).click();
		
		WebElement relationshiptype = driver.findElement(By.cssSelector("#relationship_type"));
		Select rtype = new Select(relationshiptype);
		rtype.selectByContainsVisibleText("Parent");
		driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys("Anuj");
		driver.findElement(By.cssSelector("#next-button")).click();
	}
	
@And("Clicks on the confirm button")
public void Clicks_on_the_confirm_button() {
	driver.findElement(By.xpath("//input[@id='submit']")).click();
}
@Then("Verify that the patient is successfully registered")
public void verify_that_the_patient_is_successfully_registered() {
	System.out.println("Patient registered successfully");
}
@Given("User is on Inpatient details page")
public void user_is_on_Inpatient_details_page() {
    System.out.println("Inpatient detail page displayed");
}
@And("Clicks Find Patient Records")
public void Clicks_Find_Patient_Records() {
	driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
}
@When("User searches for the patient")
public void user_searches_for_the_patient() {
	driver.findElement(By.id("patient-search")).sendKeys("Madh");
}
@And("Patient details should be listed")
public void patient_details_should_be_listed() {
	WebElement moveMouse=driver.findElement(By.xpath("//*[@id='patient-search-results-table_wrapper']/table/tbody/tr[1]"));
	Actions ac=new Actions(driver);
	ac.moveToElement(moveMouse).click().perform();
}
@And("Clicks on edit button")
public void Clicks_on_edit_button() {
	driver.findElement(By.xpath("//span[@id='edit-patient-demographics']")).click();
}
@Then("User edit and save patient name")
public void user_edits_and_save_patient_name() {
	driver.findElement(By.name("middleName")).sendKeys("Sutharia");
    driver.findElement(By.id("save-form")).click();
    driver.findElement(By.id("registration-submit")).click();
}
@Then("verify the change is reflected")
public void verify_the_change_is_reflected() {
	WebElement updatedpatientmiddlename = driver.findElement(By.xpath("//span[@class='PersonName-middleName']"));
	Assert.assertEquals("Sutharia",updatedpatientmiddlename.getText());
}
}
 
