package baseClassPack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.google.common.io.Files;

public class BaseClass {

	public static WebDriver d;
	public static Logger logger;
	
	
	@BeforeClass
	public void launchBrowser() throws Exception
	{
		d=new ChromeDriver();
		d.get("https://zepp.studentpurchaseprogram.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		
	}
	
	@AfterClass
	public void closeBrowser() throws Exception
	{
		Thread.sleep(5000);
		d.quit();
	}

	public String captureScreenshot() throws IOException
	{
		
		String timestamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)d;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\Screenshots\\"+timestamp+".png";
		Files.copy(source, new File(destination));
		return destination;
		
	}
	
	
	
}
