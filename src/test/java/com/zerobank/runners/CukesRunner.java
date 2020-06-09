package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        features = {"src\\test\\resources\\features"},
        glue = {"com\\zerobank\\stepdefnitions"},


        dryRun = false,
        tags = "@negative and @outline and @pay_bills"
)
public class CukesRunner {
}