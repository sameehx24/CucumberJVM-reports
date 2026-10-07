package org.test;

import org.baseClass.JVMReportingClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Feature/SignUp.feature",
		glue="org.stepDefinition",
		monochrome=false,
		dryRun=false,
       plugin = {
     				    "pretty" ,
     				    "html:Reports/HTML-report/adactin.html",
     				    "json:Reports/JSON-report/adactin.json",
     				    "junit:Reports/Junit-report/adactin.xml"
     				}		
		)
public class RunnerClass extends JVMReportingClass {
	
	@AfterClass
	public static void executeJVM() {
		jvmReport("Reports/JSON-report/adactin.json");
	}
	
}
