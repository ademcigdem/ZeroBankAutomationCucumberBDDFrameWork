package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

import java.util.List;

public class AccountActivityStepDef {
    Pages pages = new Pages();

    @When("the account drop down default option should be {string}")
public void the_drop_down_default_option_should_be(String defaultValue) {
        pages.accountActivity().verifyDropDownDefaultOption(defaultValue);

}

    @When("following drop down options should be have")
    public void following_drop_down_options_should_be_have(List<String> dropDownList) {
        pages.accountActivity().verifyDropDownOptions(dropDownList);

    }

    @Then("following columns name at transactions table should have")
    public void following_columns_name_at_transactions_table_should_have(List<String> columnNameList) {
        pages.accountActivity().verifyTableHeaderText(columnNameList);
    }
    @Then("the user navigate to {string} tab")
    public void the_user_navigate_to_tab(String tabName) {
    pages.accountActivity().navigateToModule(tabName);
    }

}
