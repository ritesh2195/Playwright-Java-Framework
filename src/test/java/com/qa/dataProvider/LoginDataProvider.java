package com.qa.dataProvider;

import com.qa.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDataProvider(){

        ExcelReaderUtility excelReader = null;
        try {

            excelReader = new ExcelReaderUtility("src/test/resources/TestData/LoginDetails.xlsx");

        } catch (IOException e) {

            e.printStackTrace();
        }

        int rowCount = excelReader.getRowCount("Sheet1");

        List<Object[]> loginData = new ArrayList<>();

        for (int i=0;i<rowCount-1;i++){

            String email = excelReader.getCellData("Sheet1","Email",i+2);

            String password = excelReader.getCellData("Sheet1","Password",i+2);

            loginData.add(new Object[]{email,password});
        }

        return loginData.iterator();
    }
}
