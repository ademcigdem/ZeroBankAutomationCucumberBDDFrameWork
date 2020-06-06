package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Pages;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TopPageStepDef {

    Pages pages = new Pages();
    @Then("the {string} page should be displayed")
    public void the_Account_Activity_page_should_be_displayed(String title) {
        pages.loginPage().verifyToTitle("Zero - "+title);
    }

}
