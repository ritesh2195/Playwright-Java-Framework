package Base;

import PageObejcts.HomePage;
import PageObejcts.LoginPage;
import Utilities.BrowserFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public Page page;

    BrowserFactory factory;

    protected HomePage homePage;

    protected LoginPage loginPage;

    @BeforeTest
    public void setUp(){

        factory = new BrowserFactory();

        page = factory.initBrowser();

        homePage = new HomePage(page);

        loginPage = new LoginPage(page);

    }

    @AfterMethod
    public void tearDown(){

        page.context().browser().close();

    }
}
