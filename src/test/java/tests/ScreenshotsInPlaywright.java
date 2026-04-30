package tests;

import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.ScreenshotOptions;
import utils.Utility;

import base.BaseTest;
import pages.LoginPage;

public class ScreenshotsInPlaywright extends BaseTest{
	public static void main(String[] args) {
		ScreenshotsInPlaywright browser= new ScreenshotsInPlaywright();
		browser.setup();
		LoginPage page= new LoginPage(browser.page);
		page.navigate("https://www.naukri.com/");
		
//just a screenshot
//		byte[] arr=browser.page.screenshot();
//		
//		System.out.println(arr);
		
		
//to get screenshot as file
//to embed screenshots to particular report we can store string from byte array
//		byte[] arr=browser.page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot.png")));
//		
//		System.out.println(Base64.getEncoder().encodeToString(arr));
//		
////Screenshot of particular web element
//		browser.page.locator("//*[@data-testid='backdrop']//following-sibling :: div//img[@alt='Naukri Logo']")
//		.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("logo.png")));
//		browser.tearDown();
		
//directly call screenshots method from utility
		
		byte[] arr= Utility.CaptureScreenshot(browser.page);
		System.out.println(Base64.getEncoder().encodeToString(arr));
		browser.tearDown();
	}
	
	
	
}
