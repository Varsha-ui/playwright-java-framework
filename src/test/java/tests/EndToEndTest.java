package tests;

import java.util.regex.Pattern;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class EndToEndTest {

	public static void main(String[] args) 
	{
		Browser browser = null;
		Page page = null;
		
		try {
			browser=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(2000));
			page= browser.newPage();
			page.navigate("https://www.naukri.com/nlogin/login?msg=0&URL=https%3A%2F%2Fmy.naukri.com%3A80");
			System.out.println("page title is : "+page.title());
			PlaywrightAssertions.assertThat(page).hasTitle("Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com");
			
			page.locator("#usernameField").fill("xyz");
			page.locator("#passwordField").fill("vhg");
			page.getByText("Login").nth(3).click();
			PlaywrightAssertions.assertThat(page.getByText(Pattern.compile("Invalid details")+":error message validated successfully"));
			
			page.getByTitle("Jobseeker Register").click();
			
		}
		finally {
			browser.close();
			page.close();
		}

	}

}
