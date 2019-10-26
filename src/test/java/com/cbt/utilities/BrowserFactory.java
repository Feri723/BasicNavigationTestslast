package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String str) {
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