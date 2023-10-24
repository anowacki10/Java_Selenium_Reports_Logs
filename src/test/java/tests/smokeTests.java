package tests;
import com.Utils.DriverFactory;
import com.Utils.MyLogger;
import com.testBase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.Utils.GetProperty.getProp;

public class smokeTests extends TestBase {


    @Test
    public void logoVeryfi(){
        mainPage.logoCheck();

    }

    @Test
    public void loginTopTest() throws IOException{

        mainPage.loginTopClick();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.urlToBe(getProp("expectedLoginUrl")));


    }

    @Test
    public void loginBottomTest() throws IOException {

        mainPage.loginBottomClick();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.urlToBe(getProp("expectedLoginUrl")));


    }

    @Test
    public void guidesButtonCheck() throws IOException {
        mainPage.guidesButtonClick();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 5);
        wait.until(ExpectedConditions.urlToBe(getProp("expectedGuidesUrl")));

    }


    @Test
    public void GuidesPageCheck() throws IOException, InterruptedException {
        DriverFactory.getInstance().getDriver().get(getProp("expectedGuidesUrl"));
        String text = mainPage.getGuides();
        Assert.assertEquals(text,getProp("expectedGuidesText"));



    }



}
