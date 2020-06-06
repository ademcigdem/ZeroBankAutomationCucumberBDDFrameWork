package com.zerobank.stepdefnitions;

import com.zerobank.utilities.Pages;
import io.cucumber.java.en.*;

import java.util.List;

public class AccountSummaryStepDef {
    Pages pages = new Pages();
    @Then("following account types should be displayed")
    public void following_account_types_should_be_displayed(List<String> accounTypeList) {
       pages.accountSummaryPage().verifyAccountTypeListText(accounTypeList);
    }

    @Then("following colums at Credit Account table must have")
    public void following_colums_at_table_must_have(List<String> tableColumns) {
        pages.accountSummaryPage().verifyCreditCardTableColums(tableColumns);
    }

}
