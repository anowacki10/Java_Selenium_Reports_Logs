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


public class LoginPage {
    WebDriver driver = null;
    @FindBy(xpath = "//a[normalize-space()='Test BankID']")
    WebElement testBankId;

    @FindBy(xpath = "//a[normalize-space()='Production BankID']")
    WebElement productionBankId;

    @FindBy(xpath = "//a[normalize-space()='Personal code']")
    WebElement personalCode;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/h3")
    WebElement testBankIdText;

    @FindBy(xpath = "//img[@alt='QR-code']")
    WebElement qrCode;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/div[2]/p")
    WebElement filedLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/div[2]/a[1]")
    WebElement tryAgainLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/div[2]/a[2]")
    WebElement closeLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/h3")
    WebElement productionText;

    @FindBy(xpath = "//input[@placeholder='Enter code']")
    WebElement personalCodeInput;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement codeLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/div[1]/form/div[2]/div")
    WebElement invalidCodeResponse;

    @FindBy(xpath = "//a[@class='btn bg-darkblue logincode_order__N44Ja']")
    WebElement orderPersonalCode;

    @FindBy(xpath = "//input[@id='firstname_field']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname_field']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='organization_field']")
    WebElement organization;

    @FindBy(xpath = "//input[@id='project_field']")
    WebElement project;

    @FindBy(xpath = "//input[@id='e-mailaddress_field']")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div[2]/form/button")
    WebElement orderCode;


    // Page Factory initialization by given driver
    public LoginPage(WebDriver driver){
        PageFactory.initElements(DriverFactory.getInstance().getDriver(),this);
        this.driver = driver;
    }
    // Methods

    // Click on menu bar, pass menu string to chooose particular button
    public void testBankIdClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(testBankId));
        testBankId.click();
    }
    public void productionBankIdClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(testBankId));
        productionBankId.click();
    }

    public void personalCodeClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(testBankId));
        personalCode.click();
    }

    public String getTestBankIdText() throws InterruptedException {
        Thread.sleep(2000);
        String text = testBankIdText.getText();
        return text;
    }

    public boolean getQrCodeBankID(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(qrCode));
        qrCode.isDisplayed();
        return true;

    }

    public String getFiledLoginText(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(filedLogin));
        String text = filedLogin.getText();
        return text;
    }

    public void tryAgainClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(tryAgainLogin));
        tryAgainLogin.click();
    }

    public void closeLoginClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(closeLogin));
        closeLogin.click();
    }

    public String getProductionBankIdText() throws InterruptedException {
        Thread.sleep(2000);
        String text = productionText.getText();
        return text;
    }

    public void FillPersonalCodeInput(String code){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(personalCodeInput));
        personalCodeInput.sendKeys(code);
    }

    public void codeLoginClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(codeLogin));
        codeLogin.click();
    }

    public String invalidCodeResponseText(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(invalidCodeResponse));
        String text = invalidCodeResponse.getText();
        return text;
    }

    public void orderPersonalCodeClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(orderPersonalCode));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        jsExecutor.executeScript("arguments[0].click();", orderPersonalCode);


    }

    public void fillFirstName(String fName){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fName);
    }

    public void fillLastName(String lName) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(lName);
    }

    public void fillOrganization(String organizationName) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(organization));
        organization.sendKeys(organizationName);
    }

    public void fillProjectName(String projectName) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(project));
        project.sendKeys(projectName);
    }

    public void fillEmail(String Email) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(Email);
    }

    public void orderCodeClick(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(orderCode));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        jsExecutor.executeScript("arguments[0].click();", orderCode);

    }


}
