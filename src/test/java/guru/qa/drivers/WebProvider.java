package guru.qa.drivers;

import com.codeborne.selenide.Configuration;
import guru.qa.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class WebProvider {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public static void config() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser().toString();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
        Configuration.remote = config.remoteUrl();
    }
}
