package dataTabless;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/test/java/dataTabless/ninzasin.feature",glue="dataTabless",plugin= {"pretty","html:target/sin-report.html"},monochrome=true)
public class ninjasingledata extends AbstractTestNGCucumberTests {

}
