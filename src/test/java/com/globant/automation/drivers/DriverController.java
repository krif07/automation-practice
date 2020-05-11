package com.globant.automation.drivers;

import jdk.jfr.Event;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverController {

    private WebDriver driver;

    public DriverController(String browser){
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
                break;
            case "firefox":
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
}
