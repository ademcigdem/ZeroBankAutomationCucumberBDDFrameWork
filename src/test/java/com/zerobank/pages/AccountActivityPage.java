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

    /**
     * This static Array List keeps all columns for each search and keep them all
     */
    public static ArrayList<List<String>> searchList = new ArrayList<>();



    //****GETTER METHODS****

    /**
     * This method returns description rows elements texts as lift of string
     * @return List of String
     */
    public List<String> getTableDescriptionRowElementsText() {
        return BrowserUtils.getElementsText(tableDateDiscriptionElementsList);
    }

    /**
     *
     * @return
     */
    public Select getSelectAccountTypes() {
        return new Select(accuntIdDropdown);
    }

    /**
     * This method enter description input
     * @param description
     */

    public void enterDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys("ONLINE");
    }

    /**
     * This method update/add static searchList object for each list of string
     */
    public void addResultInBag() {
        searchList.add(getElementsText(tableDateRowElementsList));
    }

    /**
     * This method sent to dates
     * @param fromDate
     * @param toDate
     */
    public void enterDateRange(String fromDate, String toDate) {
        fromDateInput.clear();
        fromDateInput.sendKeys(fromDate);
        toDateInput.clear();
        toDateInput.sendKeys(toDate);

    }

    /**
     * This method return Select object for account Type DropDown element
     * @return
     */
    public Select getTypeDropDownSelectObject() {
        return new Select(accountTypeDropDown);
    }

    /**
     * This method return select object
     * @return
     */
    public Select getSelectObject() {
        BrowserUtils.waitFor(2);
        Select select = new Select(Driver.get().findElement(By.name("accountId")));
        return select;
    }

    /**
     * This method return account ID Drop Down first selected options
     * @return
     */
    public String getSelectDefault() {
        return getSelectObject().getFirstSelectedOption().getText();
    }

    /**
     * This method return account ID Drop Down first selected options texts
     * @return
     */
    public List<String> getSelectOptionsList() {
        return getElementsText(getSelectObject().getOptions());
    }

    /**
     * This method return to table heads text
     * @return
     */
    public List<String> getTablesHeadsTexts() {

        return getElementsText(tableHeads);
    }


    // ****VERIFY METHODS****

    /**
     *
     * @param row
     */
    public void verifyAtLeastOneResult(String row) {
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
    /**
     * This method verify that results dates row just between fromdate to todate
     * it will check from alltableDateRowElements for list.
     *
     * @param expectedFromDate
     * @param expectedToDate
     */
    public void verifyDateBetweenFromTo(String expectedFromDate, String expectedToDate) {
        Assert.assertTrue(Integer.parseInt(tableDateRowElementsList.get(tableDateRowElementsList.size() - 1).getText().replace("-", "")) >= Integer.parseInt(expectedFromDate.replace("-", "")));
        Assert.assertTrue(Integer.parseInt(tableDateRowElementsList.get(0).getText().replace("-", "")) <= Integer.parseInt(expectedToDate.replace("-", "")));
    }
    /**
     * This method verify that whenwe change the search dates, this method find and check dates
     * @param changedDate
     */
    public void verifyNotContainTransactionsDated(String changedDate) {
        List<String> list1 = searchList.get(0);
        List<String> list2 = searchList.get(1);
        list1.removeAll(list2);
        Assert.assertEquals(changedDate, list1.get(0));
    }
    /**
     * This methods verify that default value of drop down options
     * @param expectedDefaultOption
     */
    public void verifyDropDownDefaultOption(String expectedDefaultOption) {
        Assert.assertEquals(expectedDefaultOption, getSelectDefault());
    }

    /**
     * This method verify all drop down options are same as given @param
     * @param dropDownList
     */
    public void verifyDropDownOptions(List<String> dropDownList) {
        Assert.assertEquals(dropDownList, getSelectOptionsList());
    }

    /**
     * This method verify tables heads row columns texts with @param
     * @param columnNameList
     */
    public void verifyTablesHeadsTexts(List<String> columnNameList) {
        Assert.assertEquals(columnNameList, getTablesHeadsTexts());
    }

    /**
     * This method verify default account drop down name
     * @param expectedSelectAccountName
     */
    public void verifyDefaultSelectAccount(String expectedSelectAccountName) {
        Assert.assertEquals(expectedSelectAccountName, getSelectDefault());
    }

    /**
     * This method will check that all rows description is include expected input
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

    /**
     * This method will check that all rows description is include unexpected input
     * @param expectedInput
     */
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

    /**
     * This method takes date from user to verify type and @row name takes true table column name
     * Method will check each row one by one is it empty or not with flag
     * @param row check
     * @param input verify type
     */
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
        boolean check = !flag;
        for (String eachRow : BrowserUtils.getElementsText(typeTableList)) {
            if (!eachRow.equals("")) {
                check = flag;
                break;
            }
        }

        Assert.assertTrue("flag" + flag, check);
    }



}
