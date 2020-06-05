package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (id = "user_login")
    public WebElement userNameInput;

    @FindBy (id = "user_password")
    public WebElement passordInput;

    @FindBy (id = "user_remember_me")
    public WebElement keepToSignCheckBox;

    @FindBy(name = "submit")
    public WebElement signInBtn;

    @FindBy(linkText = "Forgot your password ?")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessageElement;


    public void login(){
        userNameInput.sendKeys(ConfigurationReader.get("username"));
        passordInput.sendKeys(ConfigurationReader.get("password"));
        signInBtn.click();
        BrowserUtils.waitFor(2);
    }

    /**
     * Method will getting error message for invalid user name and password or blank.@
     * @return
     */
    public String getErrorMessage(){
        return errorMessageElement.getText();
    }


}
