package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.POM_Practical;


public class SD_Practical {
	
	POM_Practical  p = new POM_Practical(BaseClass.getDriver());
	
	
	@Given("User open the Browser and click on MyAccountButtton")
	public void user_open_the_browser_and_click_on_my_account_buttton() {
	    p.MyAccount(); 
		
	}  

	@When("User Click on Outer_Login button")
	public void user_click_on_outer_login_button() {
	   p.OuterLogin();
	}

	@When("user enter valid emial {string}")
	public void user_enter_valid_emial(String string1) {
	    p.Set_Email(string1);
		
	}

	@When("user enter valid passwords {string}")
	public void user_enter_valid_passwords(String string) {
	   p.Set_Password(string);
	}

	@Then("user click on inner_login button")
	public void user_click_on_inner_login_button() {
	    p.InnerLogin();
	}

	// Scenario OutLine
	
	@When("User Pass Email {string} and password {string}")
	public void user_pass_email_and_password(String string1, String string2) {
	    
		p.Set_Email(string1);
		p.Set_Password(string2);
	}

// Single Column 
	
	@When("user Click on Registeration button")
	public void user_click_on_registeration_button() {
	    
		p.Reg();
	}

	@Then("User pass values in Single Column")
	public void user_pass_values_in_single_column(DataTable dataTable) {
	    
		List <String> nam=dataTable.asList();
		for(String fe:nam)
		{
			p.Firstname(fe);
		}
		}
	
	
	// Single Row Key Value
	
	@When("User Enter FirstName Lastname Email phonnumber")
	public void user_enter_first_name_lastname_email_phonnumber(DataTable dataTable) {
		Map<String ,String> mp =dataTable.asMap();
		    
		p.Firstname(mp.get("Firstname"));
		p.lastname(mp.get("LastName"));
		p.mail(BaseClass.randomeString()+"gmail.com");
		p.phone(BaseClass.randomeNumber());
		p.password1(mp.get("Password"));
		p.conformPass(mp.get("Cpassword"));
		
		
	}
	
	

	}












