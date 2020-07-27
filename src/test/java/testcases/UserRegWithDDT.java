package testcases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ChangePassword;
import pages.ClickRegisetrationLink;
import pages.LoginIn;
import pages.Registeration;

public class UserRegWithDDT extends TestBase 

{	
	//PageBase PageBaseOject ; 
	ClickRegisetrationLink  ClickRegisteratinObject ;   
	Registeration registerationPageObject ; 
	LoginIn loginObject ; 
	ChangePassword ChangepswdObject; 
 
	@DataProvider(name = "testData")
	public static Object [][] userdata()
	{
		
	}
	
	//Registeration Data 
	String firstName="Mohmae7ad"; 
	String lastName="Ealgaaamal" ; 
	String eMail="jaaaaass555ky1@3xx.com"; 
	String Pswd="asd123456"; 
	String NewPswd="123456"; 

	@Test (priority = 1) 
	public void successfullRegisteration() throws InterruptedException
	{
		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.openRegisterLink();
		Thread.sleep(2020);

		registerationPageObject= new Registeration(driver);
		registerationPageObject.EnterData(firstName, lastName,eMail,Pswd);
		Assert.assertTrue(registerationPageObject.Successregister.getText()
				.contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void OpenLoginPage() throws InterruptedException
	{
		ClickRegisteratinObject= new ClickRegisetrationLink(driver); 
		ClickRegisteratinObject.Clicklogout();
		ClickRegisteratinObject.openloginPage()                     	; 
	}

	@Test (priority = 3)
	public void EnterLgoinData() throws InterruptedException
	{
		loginObject = new LoginIn(driver); 
		loginObject.EnterLoginData(eMail,Pswd);
		changepassword();

	}
	@Test(enabled = false)
	public void changepassword()

	{
		ChangepswdObject = new ChangePassword(driver); 
		ChangepswdObject.openMyaccountpage();
		ChangepswdObject.chagnePassword(Pswd, NewPswd);
		Assert.assertTrue(ChangepswdObject.resultconfirmation.getText()
				.contains("Password was changed"));
	}}
