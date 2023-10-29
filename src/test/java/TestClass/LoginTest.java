package TestClass;

import Base.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void LoginUserTest(String email, String password){

        homePage.navigateToLoginPage();

        assertThat(page).hasTitle("Account Login");

        loginPage.login(email,password);

        assertThat(page).hasTitle("My Account");

        System.out.println("modified");

    }

}
