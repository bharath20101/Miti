package testRunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(tags = "@Regression", features = "src\\main\\java\\testcases\\Features", glue = "stepDefinitions")

@Test
public class Runner extends AbstractTestNGCucumberTests {

}
