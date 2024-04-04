package Base;


import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Baseclass {
	
    public WebDriver driver;
	
	String baseURL;
	
@Test
@Before("@desktop")

public void Initialisation()
{
	setup();
}

@After()
@Test()
public void after ( Scenario scenario ) throws IOException
{

	if ( isCI() && scenario.isFailed() && driver instanceof TakesScreenshot )
	{
		byte[] bytes = ( (TakesScreenshot) driver ).getScreenshotAs( OutputType.BYTES );
		scenario.attach( bytes, "image/png", "ViewPort " + scenario.getName() );
	}
}




private void setup ()
{
	System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));

	baseURL = System.getProperty( "baseURL" );
	if ( baseURL == null )
	{
		//	baseURL = "https://appsdev2.mysign.ch/de";
		baseURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	}
	driver = new ChromeDriver( getOptions() );
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.get(baseURL);
	Cookie cookie = new Cookie.Builder( "mysign_cookiebanner", "NOTWENDIGtrue" )
			.path( "/" )
			.expiresOn( Date.from( Instant.now().plus( 1, ChronoUnit.DAYS ) ) )
			.build();
	driver.manage().addCookie( cookie );
	driver.navigate().refresh();
}


private ChromeOptions getOptions ()
{
	ChromeOptions options = new ChromeOptions();
	if ( isCI() )
	{

		// have commented the window size here
		options.addArguments( "--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080" );
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
	}


	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

	chromePrefs.put("profile.default_content_setting_values.notifications", 2);
	chromePrefs.put("credentials_enable_service", false);
	chromePrefs.put("profile.password_manager_enabled", false);

	options.setExperimentalOption("prefs", chromePrefs);
	options.addArguments("--remote-allow-origins=*"); 


	return options;
}

private boolean isCI ()
{
	return System.getProperty( "isCI" ) != null;
}
}