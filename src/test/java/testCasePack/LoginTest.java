package testCasePack;

import java.io.IOException;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassPack.BaseClass;
import objectPagePack.LoginPageObject;

public class LoginTest extends BaseClass {

	LoginPageObject lpo;

	@Test(enabled = false)
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
		Assert.assertEquals(lpo.invalidemailerror.getText(),
				"Please enter a valid email address (Ex: johndoe@domain.com).");
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expired OTP on personal mail");
		//enter wrong otp in verify otp field
		String otp = sc.nextLine();
		// wait for 10 seconds to enter otp
		Thread.sleep(130000);
		// enter otp in verify otp field
		lpo.verifyotpfield.sendKeys(otp);
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
	
	@Test(enabled = true)
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
	
	
}
