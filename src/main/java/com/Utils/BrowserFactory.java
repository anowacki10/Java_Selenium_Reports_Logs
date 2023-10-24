package com.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {



    // create webdriver object for given browser
    public WebDriver createBrowserInstance(String browser) throws IllegalArgumentException {
        WebDriver driver = null;


        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions fOptions = new FirefoxOptions();
            fOptions.setHeadless(true);
            fOptions.addArguments("--private");
            driver = new FirefoxDriver(fOptions);
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions iOptions = new InternetExplorerOptions();
            iOptions.addCommandSwitches("-private");
            driver = new InternetExplorerDriver(iOptions);
        } else if (driver == null) {
            throw new IllegalArgumentException("Browse value is invalid check config.properties file");
        }
        return driver;

    }
}