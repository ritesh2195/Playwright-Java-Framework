package PageObejcts;

import Utilities.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    private final Locator myAccountLink;

    private final Locator loginLink;

    private final Locator registerLink;

    public HomePage(Page page){

      this.page = page;

      this.myAccountLink = page.locator("//a[@title='My Account']");

      this.loginLink = page.locator("text=Login");

      this.registerLink = page.locator("text=Register");
    }

    public void launchURL(){

        page.navigate(ConfigReader.getInstance().getURL());

    }

    public void navigateToLoginPage(){

        myAccountLink.click();

        loginLink.click();

    }

    public void navigateToRegisterPage(){

        myAccountLink.click();

        registerLink.click();
    }
}
