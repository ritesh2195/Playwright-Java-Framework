package TestClass;

import Base.BaseTest;
import PageObejcts.HomePage;
import PageObejcts.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    HomePage homePage;

    LoginPage loginPage;

    @Test
    public void LoginUserTest(){

        homePage = new HomePage(page);

        homePage.launchURL();

        homePage.navigateToLoginPage();

        assertThat(page).hasTitle("Account Login");

        loginPage = new LoginPage(page);

        loginPage.login("abcde@gmail.com","qwerty");

        assertThat(page).hasTitle("My Account");

    }

}
