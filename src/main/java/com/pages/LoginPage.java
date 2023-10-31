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
    @FindBy(css = "#root > main > div > div > div > div > a:nth-child(1)")
    WebElement testBankId;

    @FindBy(css = "#root > main > div > div > div > div > a:nth-child(2)")
    WebElement productionBankId;

    @FindBy(css = "#root > main > div > div > div > div > a:nth-child(3)")
    WebElement personalCode;

    @FindBy(css = ".dialog_title__2jXSf")
    WebElement testBankIdText;

    @FindBy(css = "img[alt='QR-code']")
    WebElement qrCode;

    @FindBy(css = ".loginerrorpage_reason__1Ul9w")
    WebElement filedLogin;

    @FindBy(css = ".btn.bg-darkblue.loginerrorpage_button__2I67n")
    WebElement tryAgainLogin;

    @FindBy(css = "a[class='btn loginerrorpage_button__2I67n']")
    WebElement closeLogin;

    @FindBy(css = ".dialog_title__2jXSf")
    WebElement productionText;

    @FindBy(css = "input[placeholder='Enter code']")
    WebElement personalCodeInput;


    @FindBy(css = "button[type='submit']")
    WebElement codeLogin;

    @FindBy(css = ".singleinputform_errorDescription__2W6Av")
    WebElement invalidCodeResponse;

    @FindBy(css = ".btn.bg-darkblue.logincode_order__N44Ja")
    WebElement orderPersonalCode;

    @FindBy(css = "#firstname_field")
    WebElement firstName;

    @FindBy(css = "#lastname_field")
    WebElement lastName;

    @FindBy(css = "#organization_field")
    WebElement organization;

    @FindBy(css = "#project_field")
    WebElement project;

    @FindBy(css = "#e-mailaddress_field")
    WebElement email;

    @FindBy(css ="button[type='submit']")
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

    public void orderCodeClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(orderCode));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView();", orderCode);
        jsExecutor.executeScript("arguments[0].click();", orderCode);
        Thread.sleep(2000);

    }


}
