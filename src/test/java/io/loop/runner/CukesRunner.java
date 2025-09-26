package io.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-report.html", // type of report
                "json:target/json-reports/json-report.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},      // location where we store reports
        features = "src/test/resources/features", // where is my feature file are located
        glue = "io/loop/step_definitions", // where my step defs are
        dryRun = false, // part cucumber if false run all scenarios if true - cucumber create snippets for stepDefs
        tags = "@smoke",
        monochrome = true,
        publish = false // create the report on cucumber website , if "false" it does not create report

)

public class CukesRunner {
}
