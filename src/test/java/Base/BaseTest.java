package Base;

import PageObejcts.HomePage;
import PageObejcts.LoginPage;
import Utilities.BrowserFactory;
import Utilities.ExcelReader;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;

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

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){

        String email = excelReader.getCellData("Sheet1","Email",2);

        String password = excelReader.getCellData("Sheet1","Password",2);

        Object [][] objects = new Object[1][2];

        objects[0][0] = email;

        objects[0][1] = password;

        return objects;
    }

    @AfterMethod
    public void tearDown(){

        page.context().browser().close();

    }
}
