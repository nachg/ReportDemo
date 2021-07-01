import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.UUID;

import static io.qameta.allure.Allure.addAttachment;
import static org.testng.AssertJUnit.assertTrue;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.github.com");
    }

    protected void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void checkXpath(String xpath) {
        assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @Attachment(value = "screenshot", type = "image/png")
    protected byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    protected void check(String msg, Allure.ThrowableRunnableVoid runnable) {
        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult()
                .setName(msg)
                .setStatus(Status.PASSED)
                .setDescription("expected");
        Allure.getLifecycle().startStep(uuid, result);
        try {
            runnable.run();
        } catch (Throwable e) {
            Allure.getLifecycle().updateStep(uuid, step -> {
                step.setStatus(Status.FAILED);
            });
        }
        screenshot();
        Allure.getLifecycle().stopStep(uuid);
    }

    protected void expect(String msg, Allure.ThrowableRunnableVoid runnable) throws Throwable {
        addAttachment("expected", msg);
        runnable.run();
    }
}
