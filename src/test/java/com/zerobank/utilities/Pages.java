package com.zerobank.utilities;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private AccountActivity accountActivity;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public AccountSummaryPage accountSummaryPage() {
        if (accountSummaryPage == null) {
            accountSummaryPage = new AccountSummaryPage();
        }
        return accountSummaryPage;
    }

    public AccountActivity accountActivity() {
        if (accountActivity == null) {
            accountActivity = new AccountActivity();
        }
        return accountActivity;
    }
}
