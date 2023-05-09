package com.cucumber.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        glue = {"com.cucumber.testng"},
        features = {"classpath:com/cucumber/testng/features"}

        //C:\Users\anduser\IdeaProjects\CucumberProject\src\test\java\com\cucumber\testng\steps
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
/*    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/


}
