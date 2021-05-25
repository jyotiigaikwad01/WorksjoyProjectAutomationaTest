package com.worksjoy.qa.testcases;

import com.worksjoy.qa.base.TestBase;
import com.worksjoy.qa.pages.DashboardPage;
import com.worksjoy.qa.pages.ForgotPasswordPage;
import com.worksjoy.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ForgotPasswordPage forgotPasswordPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialisation();
        loginPage = new LoginPage();
    }
    @Test(priority = 1)
    public void getPageTitle(){
        loginPage.pageTitle();
    }

    @Test(priority = 2)
    public void employeeLogin(){
       dashboardPage = loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
       //Assert.assertEquals(dashboardPage,"Worksjoy","Login Successfully");
    }
    @Test(priority = 3)
    public void clickOnForgotPasswordLink(){
        forgotPasswordPage = loginPage.setForgotPasswordLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
