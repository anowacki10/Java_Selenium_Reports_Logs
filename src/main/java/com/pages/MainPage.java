package com.pages;

import com.Utils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver = null;

    @FindBy(css = "nav[class='navbar navbar-expand-md'] img[alt='Demo Bank']")
    WebElement logo;

    @FindBy(css = "div[class='header_loginContainer__ZvSvz'] a")
    WebElement loginTop;

    @FindBy(css = ".bg-orange.mb-0.btn")
    WebElement loginBottom;

    @FindBy(css = "div[class='col'] h3")
    WebElement loginPageText;

    @FindBy(css = ".smswarning_alertTitle__3Y8HR")
    WebElement warning;

    @FindBy(css = "div[id='expandable-alert-home'] p")
    WebElement warningText;

    @FindBy(css = "ul[class='d-none d-md-flex navbar-nav ms-auto'] a[class='nav-link']")
    WebElement guidesButton;

    @FindBy(css = "#expandable-alert-home > div > a:nth-child(1)")
    WebElement securityButton;

    @FindBy(css = "#expandable-alert-home > div > a:nth-child(4)")
    WebElement identityButton;

    @FindBy(css = "div[class='col'] h3")
    WebElement guides;



    // Page factory initialization by given driver to all obj

    public MainPage(WebDriver driver){
        PageFactory.initElements(DriverFactory.getInstance().getDriver(),this);
        this.driver = driver;
    }

    // Methods

    public boolean logoCheck(){
        logo.isDisplayed();
        return true;
    }

    public void loginTopClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(loginTop));
            loginTop.click();

    }

    public void loginBottomClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(loginBottom));
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  DriverFactory.getInstance().getDriver();
        jsExecutor.executeScript("arguments[0].click();", loginBottom);


    }

    public void warningClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(warning));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        jsExecutor.executeScript("arguments[0].click();", warning);

    }

    public void guidesButtonClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(guidesButton));
        guidesButton.click();
    }

    public String getWarningText(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(warningText));

        String  text = warningText.getText();
        return text;

    }

    public boolean securityButtonCheck(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(securityButton));
        boolean xxx = securityButton.isDisplayed();
        return xxx;

    }

    public boolean identityButtonCheck(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(identityButton));
        boolean xxx = identityButton.isDisplayed();

        return xxx;
    }

    public String getGuides() throws InterruptedException {
        Thread.sleep(1000);
        String text = guides.getText();
        return text;
    }



}
