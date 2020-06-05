package com.zerobank.stepdefnitions;

import io.cucumber.java.en.*;

import java.util.Map;

public class AddNewPayeeStepDef {
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> newPay) {

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String massage) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
