package com.example.banking.core.application;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = { "resources/features" },
       glue = { "com.example.banking.core.steps" }
)
public class BddRunner {
}
