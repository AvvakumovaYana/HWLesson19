package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;

public class ProjectConfiguration {
    private static final TestConfig testConfig =
        ConfigFactory.create(TestConfig.class, System.getProperties());

    public void setConfig() {
        Configuration.baseUrl = "https://astondevs.ru/";
        Configuration.browser = testConfig.browser();
        Configuration.browserVersion = testConfig.browserVersion();
        Configuration.browserSize = testConfig.browserSize();
        Configuration.pageLoadStrategy = "eager";

        if (!testConfig.isLocal())
            Configuration.remote = testConfig.remoteUrl();

        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
