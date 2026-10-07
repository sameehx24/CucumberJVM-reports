package org.hooks;



import org.baseClass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

    @After(order = 3)
    public void postcond(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] snap = ts.getScreenshotAs(OutputType.BYTES);
            s.attach(snap, "image/png", "Failure Screenshot");
            //embed is an old method use attach 
        }
    }

    @After(order = 2)
    public void after2() {
        System.out.println("After 2");
    }

    @After(order = 1)
    public void after1() {
        driver.quit();
    }
}
