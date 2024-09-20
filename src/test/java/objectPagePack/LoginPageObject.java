package objectPagePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePagePack.BaseObjectPage;

public class LoginPageObject extends BaseObjectPage {
	
	public LoginPageObject(WebDriver d) {
		super(d);
		
	}
	
	
	@FindBy(xpath="//input[@class='dont_have active']") public WebElement instituteemailidradiobutton;
	@FindBy(xpath="//input[@class='dont_have active']") public WebElement personalemailidradiobutton;
	@FindBy(xpath="(//p[@class='ptext'])[3]") 			public WebElement personalemailidradiobutton1;
	@FindBy(xpath="//input[@id='home_email']") 			public WebElement personalemailidtextfield;
	@FindBy(xpath="//button[text()='Send OTP']") 		public WebElement sendotpbutton;
	@FindBy(xpath="//input[@class='custom_input']") 	public WebElement verifyotpfield;
	@FindBy(xpath="//button[@id='submitOTP']") 			public WebElement verifyotpbutton;
	@FindBy(xpath="//div[@id='home_email-error']") 		public WebElement invalidemailerror;
	@FindBy(xpath="//p[@class='otp-error']")			public WebElement verifyfielderrormesg;
	@FindBy(xpath="//a[text()='Resend OTP']")			public WebElement sendotptext;
	
}
