package org.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"resources", "squash"})
public class RunTest {
 }
