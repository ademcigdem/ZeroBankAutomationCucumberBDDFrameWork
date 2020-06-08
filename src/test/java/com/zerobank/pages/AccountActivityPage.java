package com.zerobank.pages;

import com.zerobank.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static com.zerobank.utilities.BrowserUtils.getElementsText;

public class AccountActivityPage extends BasePage {

    @FindBy(linkText = "Show Transactions")
    public WebElement showTransactionsLink;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsLink;

//    @FindBy(xpath = "//div[@id='ui-tabs-1']/h2")
//    public WebElement boardHeaderTitle;

    @FindBy(name = "accountId")
    public WebElement accuntIdDropdown;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> tableHeads;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInput;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(xpath = "(//tbody)[2]//tr//td[1]")
    public List<WebElement> tableDateRowElementsList;

    @FindBy(xpath = "(//tbody)[2]//tr//td[2]")
    public List<WebElement> tableDateDiscriptionElementsList;

    @FindBy(id = "aa_type")
    public WebElement accountTypeDropDown;

    public static ArrayList<List<String>> searchList = new ArrayList<>();

    public List<String> getTableDescriptionRowElementsText() {
        return BrowserUtils.getElementsText(tableDateDiscriptionElementsList);
    }


    public void enterDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys("ONLINE");
    }

    public Select getSelectAccountTypes() {
        return new Select(accuntIdDropdown);
    }

    /**
     * This method verify that results dates row just between fromdate to todate
     * it will check from alltableDateRowElements for list.
     *
     * @param expectedFromDate
     * @param expectedToDate
     */
    public void verifyDateBetweenFromTo(String expectedFromDate, String expectedToDate) {
        //Assert.assertEquals(expectedFromDate, tableDateRowElementsList.get(tableDateRowElementsList.size()-1).getText());
        //Assert.assertEquals(expectedToDate, tableDateRowElementsList.get(0).getText());

        Assert.assertTrue(Integer.valueOf(tableDateRowElementsList.get(tableDateRowElementsList.size() - 1).getText().replace("-", "")) >= Integer.valueOf(expectedFromDate.replace("-", "")));
        Assert.assertTrue(Integer.valueOf(tableDateRowElementsList.get(0).getText().replace("-", "")) <= Integer.valueOf(expectedToDate.replace("-", "")));

        //Assert.assertEquals("sorted by most recent date",expectedToDate,tableDateRowElementsList.get(0).getText());
    }

    public void verifiyAtLeastOneResult(String row) {
        List<WebElement> typeTables = null;
        if (row.equalsIgnoreCase("Deposite")) {
            typeTables = Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[3]"));
        } else if (row.equalsIgnoreCase("Withdrawal")) {
            typeTables = Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[4]"));
        }
        boolean check = false;
        for (String eachRow : BrowserUtils.getElementsText(typeTables)) {
            if (!eachRow.equals("")) {
                check = true;
                break;
            }
        }
    }


    public void addResultInBag() {
        searchList.add(getElementsText(tableDateRowElementsList));
    }


    public void verifyNotContainTransactionsDated(String changedDate) {
        List<String> list1 = searchList.get(0);
        List<String> list2 = searchList.get(1);
        list1.removeAll(list2);
        Assert.assertEquals(changedDate, list1.get(0));
    }


    public void enterDateRange(String fromDate, String toDate) {
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);
        toDateInput.clear();
        toDateInput.sendKeys(toDate);

    }

    /**
     * Tihs method return Select object for account Type DropDown element
     *
     * @return
     */
    public Select getTypeDropDownSelectObject() {
        return new Select(accountTypeDropDown);
    }

    public Select getSelectObject() {
        BrowserUtils.waitFor(2);
        Select select = new Select(Driver.get().findElement(By.name("accountId")));
        return select;
    }

    public String getSelectDefault() {
        return getSelectObject().getFirstSelectedOption().getText();
    }

    public List<String> getSelectOptionsList() {
        return getElementsText(getSelectObject().getOptions());
    }

    public List<String> getTablesHeadsTexts() {

        return getElementsText(tableHeads);
    }


    // Verify Metohods;

    public void verifyDropDownDefaultOption(String expectedDefaultOption) {
        Assert.assertEquals(expectedDefaultOption, getSelectDefault());
    }

    public void verifyDropDownOptions(List<String> dropDownList) {
        Assert.assertEquals(dropDownList, getSelectOptionsList());
    }

    public void verifyTablesHeadsTexts(List<String> columnNameList) {
        Assert.assertEquals(columnNameList, getTablesHeadsTexts());
    }

    public void verifyDefaultSelectAccount(String expectedSelectAccountName) {
        Assert.assertEquals(expectedSelectAccountName, getSelectDefault());
    }
    /**
     * This method will check that all rows description is include expected input or not
     * @param expectedInput
     */
    public void verifyTableContainDescriptionTexts (String expectedInput){
        boolean check= false;
        for (String input : getTableDescriptionRowElementsText()) {
            if(!input.contains(expectedInput)){
                check=false;
                break;
            } else{
                check=true;
            }
        }
        Assert.assertTrue(check);
    }
    public void verifyTableNotContainDescriptionTexts (String expectedInput){
        boolean check= true;
        for (String input : getTableDescriptionRowElementsText()) {
            if(input.contains(expectedInput)){
                check=true;
                break;
            } else{
                check=false;
            }
        }
        Assert.assertFalse(check);
    }
    public void verifyAccountTypeResult (String row, String input) {
        BrowserUtils.waitFor(2);
        boolean flag = true;
        if (input.contains("at least one")) {
            flag = true;
        } else if (input.contains("no")) {
            flag = false;
        }
        List<WebElement> typeTableList = new ArrayList<>();
        if (row.equalsIgnoreCase("Deposit")) {
            typeTableList = Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[3]"));
        } else if (row.equalsIgnoreCase("Withdrawal")) {
            typeTableList = Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[4]"));
        }

        boolean check = !flag; //true    flag: false
        for (String eachRow : BrowserUtils.getElementsText(typeTableList)) {
            System.out.println("eachRow = " + eachRow);
            System.out.println("check = " + check);
            System.out.println("flag = " + flag);
            if (!eachRow.equals("")) {
                check = flag;
                break;
            }
        }

        Assert.assertTrue("flag" + flag, check);
    }



}
