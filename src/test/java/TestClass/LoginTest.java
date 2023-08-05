package TestClass;

import Base.BaseTest;
import PageObejcts.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    HomePage homePage;

    @Test
    public void LoginUserTest(){

        homePage = new HomePage(page);

        homePage.launchURL();

        homePage.navigateToLoginPage();

        assertThat(page).hasTitle("Account Login");

    }

}
