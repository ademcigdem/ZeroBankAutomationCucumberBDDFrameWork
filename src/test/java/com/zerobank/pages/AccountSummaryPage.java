package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.*;

public class AccountSummaryPage extends BasePage{
    @FindBy(xpath = "//h2")
    public List<WebElement> accountTypesList;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=1']")
    public WebElement saving1Link;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=3']")
    public WebElement saving2Link;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=2']")
    public WebElement checkingLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCardLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=4']")
    public WebElement loanLink;

    @FindBy(xpath = "(//thead/tr[1])[1]")
    public WebElement cashAccountHead;

    @FindBy(xpath = "(//thead/tr[1])[2]")
    public WebElement investmentAccountHead;

    @FindBy(xpath = "(//thead/tr[1])[3]")
    public WebElement creditCardAccountHead;

    @FindBy (xpath = "(//thead/tr[1])[1]//th")
    public List<WebElement> cashAccounttableHeaderList;

    @FindBy (xpath = "(//thead/tr[1])[2]//th")
    public List<WebElement> investmentAccounttableHeaderList;

    @FindBy (xpath = "(//thead/tr[1])[3]//th")
    public List<WebElement> creditCardAccounttableHeaderList;

    @FindBy (xpath = "(//thead/tr[1])[4]//th")
    public List<WebElement> loanAccounttableHeaderList;

    // (//h2[.='Cash Accounts'] /following-sibling::div //tr[1])[1]
    //Specific module name and type name text element

    public void verifyAccountTypeListText(List<String > expectedList){
        assertEquals(expectedList,BrowserUtils.getElementsText(accountTypesList));
    }

    public void verifyCreditCardTableColums(List<String> tableColumnList){
        assertEquals(tableColumnList, BrowserUtils.getElementsText(creditCardAccounttableHeaderList));
    }
}
