package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Playwright_MultiBrowserTest {

	public static void main(String[] args) 
	{
		Browser browser = null;
		Page page = null;
		
		try {
			//with firefox
			//browser=Playwright.create().firefox().launch(new LaunchOptions().setHeadless(false));
			
			//with Webkit
			//browser=Playwright.create().webkit().launch(new LaunchOptions().setHeadless(false));
			
			//with chrome
			//browser=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
			
			//with edge
			browser=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setChannel("msedge"));
			page= browser.newPage();
			page.navigate("https://www.naukri.com/nlogin/login?msg=0&URL=https%3A%2F%2Fmy.naukri.com%3A80");
			System.out.println("page title is : "+page.title());
		}
		finally {
			browser.close();
			page.close();
		}

	}

}
