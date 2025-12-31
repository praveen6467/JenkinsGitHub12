 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class POM_Practical extends BasePage  {
	
	

	 public  POM_Practical (WebDriver driver)
	 {
		 super(driver);  
	 }
	 
	 
	 
//  @FindBy(xpath="");	 
	
	 @FindBy(xpath="//a[@title='My Account']") WebElement MyAccount;
	 @FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li//a[normalize-space()='Login']")
	 WebElement OuterLogin;
	 @FindBy(xpath="//input[@id='input-email']") WebElement Email;
	 @FindBy(css="#input-password") WebElement Password;
	 @FindBy(xpath="//input[@value='Login']") WebElement InnerLogin;
	 
	 
	 
	// Action Methods
	 
	 public void MyAccount ()
     {
		 MyAccount.click();
	 }
	 public void OuterLogin() 
	 {
		 OuterLogin.click();
	 }
	 public void Set_Email(String email)
	 {
		 Email.sendKeys(email);
	 }
	 public void Set_Password(String passWord)
	 {
		 Password.sendKeys(passWord);
	 }
	 public void InnerLogin()
	 {
		 InnerLogin.click(); 
	 }
	 

	 //Register
	 
	 @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	 WebElement Register;
	 @FindBy(xpath="//input[@id='input-firstname']") WebElement Firstname;
	 @FindBy(xpath="//input[@id='input-lastname']") WebElement LastName;
	 @FindBy(xpath="//input[@id='input-email']") WebElement Reg_email;
	 @FindBy(xpath="//input[@id='input-telephone']") WebElement Phone;
	 @FindBy(xpath="//input[@id='input-password']") WebElement Password1;
	 @FindBy(xpath="//input[@id='input-confirm']") WebElement ConformPassword;
	 @FindBy(xpath="//input[@name='agree']") WebElement Agree;
	 @FindBy(xpath="//input[@value='Continue']") WebElement Continue;
	 @FindBy(xpath="//h2[normalize-space()='Newsletter']") WebElement Newsletter;
	
	 
	 public void Reg () {Register.click();}
	 public void Firstname(String string) { Firstname.sendKeys(string);}
	 public void lastname(String string) { LastName.sendKeys(string);}
	 public void mail(String string) { Reg_email.sendKeys(string);}
	 public void phone(String string) { Phone.sendKeys(string);}
	 public void password1(String string) { Password1.sendKeys(string);}
	 public void conformPass(String string) { ConformPassword.sendKeys(string);}
	 public void AgreeButton() {Agree.click();}
	 public void ContinueBut() {Continue.click();}
	 
	 
	 
	 
	 
	 

/*public boolean MyAccountDispaly()
{
	
	try
	{
		return (MyAccountPageDisplay.isDisplayed());
	}
	catch(Exception e)
	{
		return(false);
	}
} */



}



		   
















