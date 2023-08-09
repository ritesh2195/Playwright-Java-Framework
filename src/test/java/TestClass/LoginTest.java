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

        String email = excelReader.getCellData("Sheet1","Email",2);

        String password = excelReader.getCellData("Sheet1","Password",2);

        homePage.navigateToLoginPage();

        assertThat(page).hasTitle("Account Login");

        loginPage.login(email,password);

        assertThat(page).hasTitle("My Account");

    }

}
