package TestClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void LoginUserTest(){
        Playwright playwright = Playwright.create();

        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions()

                .setHeadless(false).setSlowMo(50));


    }

}
