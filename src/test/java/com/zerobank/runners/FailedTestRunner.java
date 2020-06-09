package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/failedcucumber.json",
                "html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com\\zerobank\\stepdefnitions"
)

public class FailedTestRunner {
}
