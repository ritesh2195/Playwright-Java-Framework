package PageObejcts;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private final Locator emailId;
    private final Locator passwordText;
    private final Locator loginButton;

    public LoginPage(Page page){

        this.emailId = page.locator("#input-email");

        this.passwordText = page.locator("#input-password");

        this.loginButton = page.locator("//input[@value='Login']");

    }

    public void login(String email, String password){

        emailId.fill(email);

        passwordText.fill(password);

        loginButton.click();
    }
}
