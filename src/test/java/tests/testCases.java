package tests;

import com.Utils.DriverFactory;
import com.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static com.Utils.GetProperty.getProp;
import static java.lang.Thread.*;


public class testCases extends TestBase {


    @Test
    public void warningTextMessageCheck() throws IOException{
        mainPage.warningClick();
        String text = mainPage.getWarningText();
        Assert.assertEquals(text,getProp("expectedWarningText"));


    }

    @Test
    public void TestBankID() throws IOException, InterruptedException {
        mainPage.loginTopClick();
        loginPage.testBankIdClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("expectedTestIdUrl"));
        String text = loginPage.getTestBankIdText();
        Assert.assertEquals(text,getProp("expectedTestIdText"));
        boolean  qr =loginPage.getQrCodeBankID();
        Assert.assertEquals(qr,true);
        sleep(1);
        String filedText = loginPage.getFiledLoginText();
        Assert.assertEquals(filedText, getProp("expectedFiledLoginText"));
        loginPage.tryAgainClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("expectedLoginUrl"));
        loginPage.testBankIdClick();
        sleep(10000);
        loginPage.closeLoginClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("url"));



    }
    @Test
    public void ProductionBankID() throws IOException, InterruptedException {
        mainPage.loginTopClick();
        loginPage.productionBankIdClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("expectedProductionUrl"));
        String text = loginPage.getProductionBankIdText();
        Assert.assertEquals(text,getProp("expectedProductionBankIdText"));
        boolean  qr =loginPage.getQrCodeBankID();
        Assert.assertEquals(qr,true);
        sleep(32000);
        String filedText = loginPage.getFiledLoginText();
        Assert.assertEquals(filedText, getProp("expectedFiledLoginText"));
        loginPage.tryAgainClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("expectedLoginUrl"));
        loginPage.productionBankIdClick();
        sleep(32000);
        loginPage.closeLoginClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("url"));



    }

    @Test
    public void loginCode() throws IOException, InterruptedException {
        mainPage.loginTopClick();
        loginPage.personalCodeClick();
        loginPage.FillPersonalCodeInput(getProp("invalidPersonalCode"));
        loginPage.codeLoginClick();
        String text = loginPage.invalidCodeResponseText();
        Assert.assertEquals(text, getProp("invalidCodeResponse"));
        loginPage.orderPersonalCodeClick();
        loginPage.fillFirstName(getProp("fname"));
        loginPage.fillLastName(getProp("lname"));
        loginPage.fillOrganization(getProp("organizationName"));
        loginPage.fillProjectName(getProp("projectName"));
        loginPage.fillEmail(getProp("email"));
        loginPage.orderCodeClick();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(),getProp("expectedCodeSentUrl"));



    }
    @Test
    public void securityButtonCheck(){
        mainPage.warningClick();
        boolean flag = mainPage.securityButtonCheck();
        Assert.assertEquals(flag,true);



    }
    @Test
    public void identityButtonCheck(){
        mainPage.warningClick();
        boolean flag = mainPage.identityButtonCheck();
        Assert.assertEquals(flag,true);

    }

}
