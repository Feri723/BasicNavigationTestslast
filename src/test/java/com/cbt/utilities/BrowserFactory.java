package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

   /* public static WebDriver getDriver(String str) {
        if (str.equals("edge"))
            return null;
        else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
/*
 public static WebDriver getDriver(String str){
            if(str.equals("edge"))
                  return null;
            else {
                  WebDriverManager.chromedriver().setup();
                  return new ChromeDriver();

 */

    public static WebDriver getDriver(String browser) {
        String os = System.getProperty("os.name");
        System.out.println("Your operating system is " + os);


        if ("safari".equals(browser.toLowerCase())) {
            if (os.toLowerCase().contains("win")) {
                return null;
            }
            WebDriverManager.getInstance(SafariDriver.class).setup();
            return new SafariDriver();
        } else if ("edge".equals(browser.toLowerCase())) {
            if (os.toLowerCase().contains("mac")) {
                return null;
            }
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if ("chrome".equals(browser.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        return null;
    }
}