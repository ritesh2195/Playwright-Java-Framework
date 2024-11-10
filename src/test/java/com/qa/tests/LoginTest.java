package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.dataProvider.LoginDataProvider;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(dataProviderClass = com.qa.dataProvider.LoginDataProvider.class,dataProvider = "LoginDataProvider")
    public void LoginUserTest(String email, String password){

        homePage.navigateToLoginPage().doLogin(email,password);

        assertThat(page).hasTitle("My account - My Shop");

    }

}
