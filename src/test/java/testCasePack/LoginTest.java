package testCasePack;

import java.io.IOException;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassPack.BaseClass;
import objectPagePack.LoginPageObject;

public class LoginTest extends BaseClass {

	LoginPageObject lpo;
	
	@Test(enabled = true)
	public void loginTestPositive() throws InterruptedException, IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click personal email id radio button
		lpo.personalemailidradiobutton1.click();
		// verify personal email id radio button is selected or not
		Assert.assertTrue(lpo.personalemailidradiobutton.isSelected(), "It is not enabled after click");
		// enter personal email id in email id text field
		lpo.personalemailidtextfield.sendKeys("msat119393@gmail.com");
		// click send otp button
		lpo.sendotpbutton.click();
		Thread.sleep(2000);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP reveived on personal mail");
		String otp = sc.nextLine();
		// wait for 10 seconds to enter otp
		Thread.sleep(10000);
		// enter otp in verify otp field
		lpo.verifyotpfield.sendKeys(otp);
		// click verify otp button on login page
		lpo.verifyotpbutton.click();
		// wait for some time
		Thread.sleep(5000);
		//navigated to registration form then enter student name
		lpo.registerpagestudentnamefield.sendKeys("Mohammed Shafi");
		//enter institute name
		lpo.registerpageinstituenamefield.sendKeys("Osmania University");
		//select 'upload institute document' option
		lpo.registerpageuploadstudentdocumentradiobutton.click();
		//click choose student document file
		lpo.registerpagestudentdocchoosefile.sendKeys("C:\\Users\\pc\\Downloads.jpeg");
		//click submit button
		lpo.registerpagesubmitbutton.click();
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestInvalidEmail() throws IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click personal email id radio button
		lpo.personalemailidradiobutton1.click();
		// verify personal email id radio button is selected or not
		Assert.assertTrue(lpo.personalemailidradiobutton.isSelected(), "It is not enabled after click");
		// enter personal email id in email id text field
		lpo.personalemailidtextfield.sendKeys("msat119393gmail.com");
		// click send otp button
		lpo.sendotpbutton.click();
		// verify error message just below the email text field
		Assert.assertEquals(lpo.invalidemailerror.getText(),"Please enter a valid email address (Ex: johndoe@domain.com).");
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestNullEmailTextField() throws IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click personal email id radio button
		lpo.personalemailidradiobutton1.click();
		// verify personal email id radio button is selected or not
		Assert.assertTrue(lpo.personalemailidradiobutton.isSelected(), "It is not enabled after click");
		// enter personal email id in email id text field
		lpo.personalemailidtextfield.sendKeys("");
		// click send otp button
		lpo.sendotpbutton.click();
		// verify error message just below the email text field
		Assert.assertEquals(lpo.invalidemailerror.getText(), "This is a required field.");
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestVerifyOTPWithInvalidOTP() throws InterruptedException, IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click personal email id radio button
		lpo.personalemailidradiobutton1.click();
		// verify personal email id radio button is selected or not
		Assert.assertTrue(lpo.personalemailidradiobutton.isSelected(), "It is not enabled after click");
		// enter personal email id in email id text field
		lpo.personalemailidtextfield.sendKeys("msat119393@gmail.com");
		// click send otp button
		lpo.sendotpbutton.click();
		//enter wrong otp in verify otp field
		lpo.verifyotpfield.sendKeys("123456");
		// wait for 10 seconds to enter otp
		Thread.sleep(3000);
		// click verify otp button on login page
		lpo.verifyotpbutton.click();
		//verify error message just below verify otp text field as "OTP expired.Please try Resend OTP"
		Assert.assertEquals(lpo.verifyfielderrormesg.getText(), "Wrong OTP, Please Enter the Correct OTP");
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}
	
	
	@Test(enabled = false)
	public void loginTestVerifyOTPWithExpiredOTP() throws InterruptedException, IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click personal email id radio button
		lpo.personalemailidradiobutton1.click();
		// verify personal email id radio button is selected or not
		Assert.assertTrue(lpo.personalemailidradiobutton.isSelected(), "It is not enabled after click");
		// enter personal email id in email id text field
		lpo.personalemailidtextfield.sendKeys("msat119393@gmail.com");
		// click send otp button
		lpo.sendotpbutton.click();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expired OTP on personal mail");
		String otp = sc.nextLine();
		// wait for 10 seconds to enter otp
		Thread.sleep(130000);
		// enter otp in verify otp field
		lpo.verifyotpfield.sendKeys(otp);
		// click verify otp button on login page
		lpo.verifyotpbutton.click();
		//verify error message just below verify otp text field as "OTP expired.Please try Resend OTP"
		Assert.assertEquals(lpo.verifyfielderrormesg.getText(), "OTP expired.Please try Resend OTP");
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}
	
	@Test(enabled = false)
	public void loginTestVerifyOTPWithNulldataOTP() throws InterruptedException, IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click personal email id radio button
		lpo.personalemailidradiobutton1.click();
		// verify personal email id radio button is selected or not
		Assert.assertTrue(lpo.personalemailidradiobutton.isSelected(), "It is not enabled after click");
		// enter personal email id in email id text field
		lpo.personalemailidtextfield.sendKeys("msat119393gmail.com");
		// click send otp button
		lpo.sendotpbutton.click();
		// click verify otp button on login page
		lpo.verifyotpbutton.click();
		}
		catch(Exception e)
		{
			captureScreenshot();
		}

	}
	
	@Test(enabled=false)
	public void mobileNumOTPFieldValidData() throws IOException, InterruptedException
	{
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click mobile number option on login page
		lpo.mobileNumradioOption.click();
		// verify mobile number radio button is selected or not
		Assert.assertTrue(lpo.mobileNumradiobutton.isSelected(), "It is not enabled after click");
		//enter mobile number in mobile number text field
		lpo.mobileNumtextfield.sendKeys("9347746181");//7995252366
		//click send otp button
		lpo.mobilenumsendOTPbutton.click();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP received on submitted mobile number");
		String otp = sc.nextLine();
		// wait for 10 seconds to enter otp
		Thread.sleep(10000);
		//enter otp received on submitted mobile number
		lpo.mobilenumverifyOTPfield.sendKeys(otp);
		//click verify otp button
		lpo.mobilenumverifyOTPbutton.click();
		//wait for 3 seconds
		Thread.sleep(3000);
		//capture screenshot
//		captureScreenshot();
		//enter institute email address(invalid)
		lpo.instituteemailaddressfield.sendKeys("msat119393@gmail.com");
		//click 'send OTP' button
		lpo.instituteemailaddressfieldsendOTPbutton.click();
		//verify error message on institute email address field
		Assert.assertEquals(lpo.instituteemailaddressfielderrormsg.getText(), "Please enter institute Email Id"); 
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}
	
	@Test(enabled=false)
	public void mobileNumOTPFieldInvalidData() throws IOException, InterruptedException
	{
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click mobile number option on login page
		lpo.mobileNumradioOption.click();
		// verify mobile number radio button is selected or not
		Assert.assertTrue(lpo.mobileNumradiobutton.isSelected(), "It is not enabled after click");
		//enter mobile number in mobile number text field
		lpo.mobileNumtextfield.sendKeys("12345678922");
		//click send otp button
		lpo.mobilenumsendOTPbutton.click();
		//verify error message
		Assert.assertEquals(lpo.invalidmobilefielderrormsg.getText(), "Please enter a valid 10-digit mobile number.");
		//wait for 3 seconds
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}
	
	@Test(enabled=false)
	public void mobileNumOTPFieldNullData() throws IOException, InterruptedException
	{
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click mobile number option on login page
		lpo.mobileNumradioOption.click();
		// verify mobile number radio button is selected or not
		Assert.assertTrue(lpo.mobileNumradiobutton.isSelected(), "It is not enabled after click");
		//enter personal mobile number in mobile number text field
		lpo.mobileNumtextfield.sendKeys("");
		//click send otp button
		lpo.mobilenumsendOTPbutton.click();
		//verify error message
		Assert.assertEquals(lpo.invalidmobilefielderrormsg.getText(), "Please enter a valid 10-digit mobile number.");
		//wait for 3 seconds
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}
	
	@Test(enabled = false)
	public void mobileVerifyOTPWithExpiredOTP() throws InterruptedException, IOException {
		lpo = new LoginPageObject(d);
		try {
		// verify institute email id radio button is enabled by default
		Assert.assertTrue(lpo.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
		// click mobile number option on login page
		lpo.mobileNumradioOption.click();
		// verify mobile number radio button is selected or not
		Assert.assertTrue(lpo.mobileNumradiobutton.isSelected(), "It is not enabled after click");
		// enter valid mobile number in mobile number text field
		lpo.mobileNumtextfield.sendKeys("9347746181");
		// click send otp button
		lpo.sendotpbutton.click();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expired OTP on submitted mobile number");
		String otp = sc.nextLine();
		// wait for 10 seconds to enter otp
		Thread.sleep(130000);
		// enter otp in verify otp field
		lpo.mobilenumverifyOTPfield.sendKeys(otp);
		// click verify otp button on login page
		lpo.mobilenumverifyOTPbutton.click();
		//verify error message just below verify otp text field as "OTP expired.Please try Resend OTP"
		Assert.assertEquals(lpo.mobilenumverifyOTPfielderrormsg.getText(), "OTP expired.Please try Resend OTP");
		}
		catch(Exception e)
		{
			captureScreenshot();
		}
	}
	
}
