package com.qa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private final Locator emailTextLocator;
    private final Locator passwordTextLocator;
    private final Locator loginButtonLocator;

    public LoginPage(Page page){

        this.emailTextLocator = page.locator("#email");

        this.passwordTextLocator = page.locator("#passwd");

        this.loginButtonLocator = page.locator("#SubmitLogin");

    }

    public void doLogin(String email, String password){

        emailTextLocator.fill(email);

        passwordTextLocator.fill(password);

        loginButtonLocator.click();
    }
}
