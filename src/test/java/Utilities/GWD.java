package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    // Her 1 threde özel lokal static driver oluşturdum.
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // webDriver 1 , webDriver 2.
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox

    // threadDriver.get() --> bulunduğum thread deki driverı ver
    // threadDriver.set(driver) --> bulunduğum thread e driver set ediliyor
    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        // Diğer senaryolar için default Chrome olsun
        if (threadBrowserName.get() == null)
            threadBrowserName.set("chrome");

        if (threadDriver.get() == null) { // 1 kere çalışssın

            switch (threadBrowserName.get())
            {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;

                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;

                default:
                    //chrome
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    threadDriver.set(new ChromeDriver(options));
                    break;

                    // bu şekilde Jenkins çalışmadığında hafıza da açılan chrome u maximize etme yolu
               //  options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
            }
        }

        threadDriver.get().manage().window().maximize();
        return threadDriver.get();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) { // dolu ise, boş değilse
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get(); driver=null;
            threadDriver.set(driver);
        }
    }
    public static void threadBrowserSet(String browser) {
        threadBrowserName.set(browser);
    }
    public static String threadBrowserGet() {
        return threadBrowserName.get();
    }
}
