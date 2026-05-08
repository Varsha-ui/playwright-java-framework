package tests;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class VedioRecordPlaywright{

	public static void main(String[] args) 
	{
		Browser browser= Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(2000));
		
		BrowserContext context= browser.newContext(new NewContextOptions().setRecordVideoSize(1000,1000).setRecordVideoDir(Paths.get("vedios/")));
		
		Page page=context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		page.fill("#email1", "admin@gmail.com");
		page.getByPlaceholder("Enter Password").fill("admin@123");
		page.getByText("sign in").nth(1).click();
		
		String path=page.video().path().toString();
		System.out.println("path of the vedio recording is :" +path);
		
		context.close();
		page.close();

	}

}
