package com.qa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    private final Page page;

    private final Locator signInLocator;

    public HomePage(Page page){

      this.page = page;

      this.signInLocator = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Sign in"));
    }

    public LoginPage navigateToLoginPage(){

        signInLocator.click();

        return new LoginPage(page);

    }

}
