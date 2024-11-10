package com.qa.base;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.BrowserUtility;
import com.qa.utility.ExcelReaderUtility;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseTest {

    public Page page;

    BrowserUtility factory;

    protected HomePage homePage;

    @BeforeMethod
    public void setup(){

        factory = new BrowserUtility();

        page = factory.initBrowser();

        homePage = new HomePage(page);

    }

    @AfterMethod
    public void tearDown(){

        page.context().browser().close();

    }
}
