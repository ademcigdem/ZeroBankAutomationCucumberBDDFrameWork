package com.zerobank.stepdefnitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static org.junit.Assert.*;

public class LoginStepDef {
    Pages pages = new Pages();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        pages.loginPage().login();
    }

    @Given("the user should not be able to login with credentials")
    public void the_user_should_not_be_able_to_login_with_credentials() {
    pages.loginPage().loginAs("userNAME","Password");
    }

    @Then("login error message should be displayed")
    public void login_error_message_should_be_displayed() {
        assertTrue(pages.loginPage().errorMessageElement.isDisplayed());
        assertEquals("Login and/or password are wrong.",pages.loginPage().getErrorMessage());
    }

    @Given("the user should not be able to login with blank")
    public void the_user_should_not_be_able_to_login_with_blank() {
        pages.loginPage().loginAs(" "," ");
    }

}
