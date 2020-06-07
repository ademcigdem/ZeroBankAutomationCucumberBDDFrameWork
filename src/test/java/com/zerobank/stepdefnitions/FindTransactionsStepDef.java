package com.zerobank.stepdefnitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

public class FindTransactionsStepDef {
    Pages pages = new Pages();

    @Then("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        pages.accountActivity().findTransactionsLink.click();
        BrowserUtils.waitFor(1);

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
       pages.accountActivity().enterDateRange(fromDate,toDate);
    }


    @Then("results table should only show transactions dates between {string} to {string} and should be sorted by most recent date")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        pages.accountActivity().verifyDateBetweenFromTo(fromDate,toDate);
    }

//    @Then("the results should be sorted by most recent date")
//    public void the_results_should_be_sorted_by_most_recent_date() {
//
//    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("clicks search")
    public void clicks_search() {
        pages.accountActivity().findButton.click();
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
