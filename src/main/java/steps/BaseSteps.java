package steps;//import com.sun.tools.javac.code.Attribute;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import utils.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;

    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver(){
        return driver;
    }



    @Before
    public static void setUp() throws Exception {
        BrowserType arg;
        arg = BrowserType.valueOf(properties.getProperty("browser"));
        switch (arg) {
            case firefox:
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() throws Exception{
        driver.quit();

    }

    public enum BrowserType {
        firefox,
        chrome;
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
