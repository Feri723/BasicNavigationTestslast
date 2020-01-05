package com.cbt.tests.HomeworkSyncronization;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class TestCase1$6 {
   private WebDriverWait wait;

   @Test
   public void stup(){
       WebDriver driver=BrowserFactory.getDriver("chrome");
       driver.get("https://qa1.vytrack.com/");
       driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
       driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
       driver.findElement(By.cssSelector("[name=_submit]")).click();
       wait= new WebDriverWait(Driver.get(),5);
       WebElement loaderMask = Driver.get().findElement(By.cssSelector("div[class='loader-mask shown']"));
       wait.until(ExpectedConditions.invisibilityOf(loaderMask));
       wait.until(ExpectedConditions.invisibilityOf(loaderMask));

       WebElement activitiesElement=Driver.get().findElement(By.linkText("Activities"));
       wait.until(ExpectedConditions.visibilityOf(activitiesElement));
       activitiesElement.click();
   }


    @BeforeMethod
    public void setup(){


    }
    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){



    }

    @AfterMethod
    public void teardown(){

    }
}

