package base;

import com.microsoft.playwright.*;

public class BaseTest 
{
	protected Playwright playwright;
	protected Browser browser;
    protected Page page;
    
    public void setup() {
    	browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    	page= browser.newPage();
    }
    
    public void tearDown()
    {
    	browser.close();
    	page.close();
    }
	

}
