package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:${browser}.properties"
})
public interface TestConfig extends Config {
    @DefaultValue("chrome")
    String browser();

    @DefaultValue("120.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("true")
    boolean isLocal();

    String remoteUrl();
}
