package com.zerobank.pages.pay_bills;

import com.zerobank.utilities.BasePage;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.zerobank.utilities.BrowserUtils.*;

public class PaySavedPayeeSubTab extends BasePage {

    @FindBy(id="sp_amount")
    public WebElement amountInput;

    @FindBy(id="sp_date")
    public WebElement dateInput;

    @FindBy(id="sp_description")
    public WebElement descriptionInput;

    @FindBy(id="pay_saved_payees")
    public WebElement payBtn;

    /**
     * This method will done pay operation for user with these data;
     * You can use it for @positive(successful) and @negative(unsuccessful) Scenarios
     * @param amount
     * @param date
     */
    public void setPayOperation(String amount, String date){
        int shortWait = Integer.valueOf(ConfigurationReader.get("shortWait"));
        waitForVisibility(amountInput,shortWait).sendKeys(amount);
        waitForVisibility(dateInput,shortWait).sendKeys(date);
        waitFor(2);
        waitForClickablility(payBtn,shortWait).click();
    }

}
