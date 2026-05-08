package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Playwright_HeadlessModeRun {

	public static void main(String[] args) 
	{
		Browser browser = null;
		Page page = null;
		
		try {
			
			//with chromium
			Playwright pw=Playwright.create();
			BrowserType browserType= pw.chromium();
			
			//Headed mode running
			//browser= browserType.launch();
			
			//headlessMode
			browser= browserType.launch(new LaunchOptions().setHeadless(false));
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
