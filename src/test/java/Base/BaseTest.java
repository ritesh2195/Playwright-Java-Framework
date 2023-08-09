package Base;

import PageObejcts.HomePage;
import PageObejcts.LoginPage;
import Utilities.BrowserFactory;
import Utilities.ExcelReader;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public Page page;

    BrowserFactory factory;

    protected HomePage homePage;

    protected LoginPage loginPage;

    protected ExcelReader excelReader;

    @BeforeTest
    public void setUp(){

        factory = new BrowserFactory();

        page = factory.initBrowser();

        homePage = new HomePage(page);

        loginPage = new LoginPage(page);

        try {

            excelReader = new ExcelReader("src/test/resources/TestData/LoginDetails.xlsx");

        } catch (Exception e){

            e.printStackTrace();
        }

    }

    @AfterMethod
    public void tearDown(){

        page.context().browser().close();

    }
}
