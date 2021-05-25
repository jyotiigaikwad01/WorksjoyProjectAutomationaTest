package com.worksjoy.qa.pages;

import com.worksjoy.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory
    @FindBy(xpath = "//input[@id='email']")
    WebElement username;

    @FindBy(xpath = "//input[contains(@name,'pswd')]")
    WebElement password;

    @FindBy(xpath = "//i[@class=\"fa fa-eye errspan\"]")
    WebElement showPassword;

    @FindBy(xpath = "//*[@id=\"formContent\"]/form/button")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(@text(),'')]")
    WebElement forgotPasswordLink;

    //initialisa
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String pageTitle(){
        return driver.getTitle();
    }

    public DashboardPage loginDetails(String un,String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        showPassword.click();
        loginBtn.click();
        return new DashboardPage();
    }

    public ForgotPasswordPage setForgotPasswordLink(){
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }
}
