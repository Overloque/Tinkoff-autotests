package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.WebConfig;
import guru.qa.config.WebProvider;
import guru.qa.helpers.Attach;
import guru.qa.pages.CreditPage;
import guru.qa.pages.DebitCardPage;
import guru.qa.pages.MainPage;
import guru.qa.pages.SavingsPage;
import guru.qa.utils.TestDataVariables;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    TestDataVariables variables = new TestDataVariables();
    private static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        WebProvider webProvider = new WebProvider(config);
        webProvider.webConfiguration();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenShotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLog();
        Attach.addVideo();

        Selenide.closeWebDriver();
    }
}
