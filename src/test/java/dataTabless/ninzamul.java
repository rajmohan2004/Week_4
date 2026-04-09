package dataTabless;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/test/java/dataTabless/ninjamul.feature",glue="dataTabless",plugin= {"pretty","html:target/mul-report.html"},monochrome=true)
public class ninzamul extends AbstractTestNGCucumberTests {

}
