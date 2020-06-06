package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class AccountActivity extends BasePage {

    @FindBy(xpath = "//div[@id='ui-tabs-1']/h2")
    public WebElement boardHeaderTitle;

    @FindBy(linkText = "Show Transactions")
    public WebElement showTransactionsLink;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsLink;

    @FindBy(id = "aa_accountId")
    public WebElement accountIdDropDown;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> tableHeads;


    public String getBoardHeaderTitle() {
        return boardHeaderTitle.getText();
    }

    public Select getSelectObject() {
        return new Select(accountIdDropDown);
    }

    public String getSelectDefault() {
        return getSelectObject().getFirstSelectedOption().getText();
    }

    public List<String> getSelectOptionsList() {
        return BrowserUtils.getElementsText(getSelectObject().getOptions());

    }
    public List<String> getTableHeadsTexts() {
        return BrowserUtils.getElementsText(tableHeads);
    }
    public void verifyDropDownDefaultOption(String expectedDefaultOption){
        assertEquals(expectedDefaultOption,getSelectDefault());
    }

    public void verifyDropDownOptions(List<String> dropDownList){
        assertEquals(dropDownList,getSelectOptionsList());
    }

    public void verifyTableHeaderText(List<String> columnNameList){
        assertEquals(columnNameList,getTableHeadsTexts());
    }

}
