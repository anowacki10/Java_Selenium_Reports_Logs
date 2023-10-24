package com.Utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    // singleton desing pattern - only one instace exist, provide global acces to that instance by getInstance method
    private DriverFactory(){
    }
    private static DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance(){
        return instance;
    }

    // ThreadLocal in factory desing pattern
    ThreadLocal<WebDriver> driverr = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return driverr.get();
    }
    public void setDriver(WebDriver driverParm){
        driverr.set(driverParm);
    }
    public void closeBrowser(){
        driverr.get().quit();
        driverr.remove();
    }

}
