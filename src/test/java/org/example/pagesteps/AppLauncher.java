package org.example.pagesteps;

import com.thoughtworks.gauge.Step;
import org.example.utils.*;

public class AppLauncher {

    public static String APP_URL = System.getenv("APP_URL");

    @Step("User open the homepage")
    public void launchSite() {
        Driver.webDriver.get(APP_URL);
    }
}
