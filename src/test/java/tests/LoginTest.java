package tests;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	public static void main(String[] args) 
	{
		LoginTest test= new LoginTest();
		test.setup();
		LoginPage login= new LoginPage(test.page);
		
		login.navigate("https://freelance-learn-automation.vercel.app/login");
		
		login.login("admin@gmail.com", "admin@123");
		
		String title=test.page.title();
		
		System.out.println("Title is :" +title);
		
		test.tearDown();

	}

}
