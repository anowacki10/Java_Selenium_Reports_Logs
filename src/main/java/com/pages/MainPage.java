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

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-md']//img[@alt='Demo Bank']")
    WebElement logo;

    @FindBy(xpath = "//div[@class='header_loginContainer__ZvSvz']//a[normalize-space()='Log in']")
    WebElement loginTop;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div[2]/div/div[1]/div[2]/a")
    WebElement loginBottom;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/h3")
    WebElement loginPageText;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div[1]/button/div[1]/div")
    WebElement warning;

    @FindBy(xpath = "//*[@id=\"expandable-alert-home\"]/p")
    WebElement warningText;

    @FindBy(xpath = "//ul[@class='d-none d-md-flex navbar-nav ms-auto']//a[@class='nav-link'][normalize-space()='Guides']")
    WebElement guidesButton;

    @FindBy(xpath = "//a[normalize-space()='BankID and security']")
    WebElement securityButton;

    @FindBy(xpath = "//a[normalize-space()='Identity theft']")
    WebElement identityButton;

    @FindBy(xpath = "//h3[normalize-space()='Useful guides']")
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
