package com.zerobank.pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.zerobank.utilities.BrowserUtils.*;
import static com.zerobank.utilities.ConfigurationReader.*;

public class LoginPage extends BasePage {

    @FindBy (id = "user_login")
    public WebElement userNameInput;

    @FindBy (id = "user_password")
    public WebElement passwordInput;

    @FindBy (name = "submit")
    public WebElement singInButton;

    @FindBy (partialLinkText = "Forgot your password")
    public WebElement forgotPassLink;

    @FindBy (css = ".alert.alert-error")
    public WebElement errorMessage;

    public void login(){
        userNameInput.sendKeys(get("username"));
        passwordInput.sendKeys(get("password"), Keys.ENTER);
       waitFor(2);
    }

    public void loginAs(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
        waitFor(2);
    }

    public String getErrorMessage (){
        return errorMessage.getText();
    }


}
