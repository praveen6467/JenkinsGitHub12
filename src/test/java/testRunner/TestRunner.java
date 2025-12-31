



package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features= {".//Features/Z_PRACTICAL.feature"},
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:reports/myreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        },
        monochrome = true,
        publish = true,
        tags = "@Sanity"  
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
