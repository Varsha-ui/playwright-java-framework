package pages;

import com.microsoft.playwright.*;

public class LoginPage {
	private Page page;
	
	public LoginPage(Page page) 
	{
		this.page=page;
		
	}
	public void navigate(String url) 
	{
		page.navigate(url);
	}
	public void login(String Username, String Password) 
	{
		page.fill("#email1", Username);
		page.getByPlaceholder("Enter Password").fill(Password);
		page.getByText("sign in").nth(1).click();
	}
	

}
