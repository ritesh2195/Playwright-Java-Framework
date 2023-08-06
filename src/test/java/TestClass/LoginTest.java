package TestClass;

import Base.BaseTest;
import PageObejcts.HomePage;
import PageObejcts.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void LoginUserTest(){

        homePage.navigateToLoginPage();

        assertThat(page).hasTitle("Account Login");

        loginPage.login("abcde@gmail.com","qwerty");

        assertThat(page).hasTitle("My Account");

    }

}
