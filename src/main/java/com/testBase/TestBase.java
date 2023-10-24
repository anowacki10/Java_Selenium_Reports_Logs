package com.testBase;
import com.Utils.BrowserFactory;
import com.Utils.DriverFactory;
import com.pages.LoginPage;
import com.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.Utils.GetProperty.getProp;


public class TestBase {
    BrowserFactory bf = new BrowserFactory();
    public MainPage mainPage;
    public LoginPage loginPage;



    @BeforeMethod
    public void lunchApp() throws IOException {


        String browser = getProp("browser");
        String url = getProp("url");
        DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));


        mainPage = new MainPage(DriverFactory.getInstance().getDriver());
        loginPage = new LoginPage(DriverFactory.getInstance().getDriver());
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().get(url);



    }


    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().closeBrowser();
    }
}
