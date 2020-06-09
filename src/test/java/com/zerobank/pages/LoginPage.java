package com.zerobank.pages;

import com.zerobank.utilities.BasePage;
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

    /**
     * This method user login the url via using Config.Pro. credentials
     * It takes username and password
     */
    public void login(){
        userNameInput.sendKeys(get("username"));
        passwordInput.sendKeys(get("password"));
        singInButton.click();
       waitFor(1);
    }

    /**
     * This method created for negative login test
     * @param username
     * @param password
     */
    public void loginAs(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        singInButton.click();
        waitFor(1);
    }

    /**
     * This method return error message for unseccesful login invalid credentials
     * @return
     */
    public String getErrorMessage (){
        return errorMessage.getText();
    }


}
