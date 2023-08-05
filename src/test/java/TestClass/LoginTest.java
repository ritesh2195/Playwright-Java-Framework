package TestClass;

import Base.BaseTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginUserTest(){

        page.navigate("https:google.com");
    }

}
