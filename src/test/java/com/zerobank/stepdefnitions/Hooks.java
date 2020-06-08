package com.zerobank.stepdefnitions;



import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.zerobank.utilities.BrowserUtils.*;
import static com.zerobank.utilities.ConfigurationReader.*;

public class Hooks {


    @Before
    public void setup(){

        Driver.get().manage().window().maximize();
        Driver.get().get(get("url"));
        Driver.get().manage().timeouts().implicitlyWait(Long.parseLong(get("implicitwait")), TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        waitFor(2);

        Driver.closeDriver();
    }


}
