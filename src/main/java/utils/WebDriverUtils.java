package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import static utils.AllureUtils.takeScreenshot;

public class WebDriverUtils {
    public static WebDriver DRIVER;
    public static WebDriverWait WAIT;

    public static void setUpBrowser() {
        DRIVER = getNewChromeDriver();
        long segundosDeEspera = Long.parseLong(System.getProperty("elementWait", "10"));
        WAIT = new WebDriverWait(DRIVER, Duration.ofSeconds(segundosDeEspera));
    }

    public static void closeBrowser() { DRIVER.quit(); }

    private static WebDriver getNewChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--ignore-certificate-errors");

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        if (headless) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
        }

        String rutaDescargas = Paths.get("build/downloads").toAbsolutePath().toString();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", rutaDescargas);
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(System.getProperty("elementWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("pageLoadWait"))));
        return driver;
    }

    @Step("Cambia a la pesta\u00F1a {windowName}")
    public static void switchWindow(String windowName) {
        boolean windowFind = false;
        Set<String> windows = DRIVER.getWindowHandles();
        for (String window : windows) {
            DRIVER.switchTo().window(window);
            if (DRIVER.getTitle().contains(windowName)) {
                windowFind = true;
                break;
            }
        }
        takeScreenshot();
        if (!windowFind) throw new AssertionError("No se encontro la pesta\u00F1a " + windowName);
    }
}