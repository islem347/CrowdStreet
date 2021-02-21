package com.crowdstreet.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber.html"

        },
        features = "src/test/resources/Registration.feature",
        glue = "com/crowdstreet/step_definitions",

        tags = "@wip",
        publish = true



)
public class CucumberRunner {

}
