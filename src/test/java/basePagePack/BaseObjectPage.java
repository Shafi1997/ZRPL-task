package basePagePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseObjectPage {

	public static WebDriver d;
	
	public BaseObjectPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	
	
}
