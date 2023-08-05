package Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public Playwright playwright;

    public Browser browser;

    public Page page;

    @BeforeTest
    public void setUp(){

        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)

                .setSlowMo(50));

        page = browser.newPage();

    }

    @AfterMethod
    public void tearDown(){

        page.close();

        browser.close();

        playwright.close();

    }
}
