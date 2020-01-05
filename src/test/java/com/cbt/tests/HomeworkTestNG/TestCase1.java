package com.cbt.tests.HomeworkTestNG;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }
    @Test(description = "Verify that warning message is displayed")
    public void test1(){

        String expectedResult="The date of birth is not valid";
        driver.findElement(By.cssSelector("[placeholder=\"MM/DD/YYYY\"]")).sendKeys("wrong_dob");
String actualResult=driver.findElement(By.cssSelector("[data-bv-result=INVALID]")).getText();
        Assert.assertEquals(expectedResult,actualResult,"input is not true");
    }

    @Test(description = "Verify that following options for programing languages are displayed")
    public void test2(){
        WebElement Cplusplus =driver.findElement(By.cssSelector("[id=\"inlineCheckbox1\"]"));
        WebElement jaca=driver.findElement(By.cssSelector("[id=\"inlineCheckbox2\"]"));
        WebElement JavaScript= driver.findElement(By.cssSelector("[id=\"inlineCheckbox3\"]"));

        Assert.assertTrue(Cplusplus.isDisplayed(),"Cplusplus is not displayed");
        Assert.assertTrue(jaca.isDisplayed(),"java is not displayed");
        Assert.assertTrue(JavaScript.isDisplayed(),"JavaScript is not isplayed");
    }
    @Test(description = "Verify that warning message is displayed")
    public void test3(){
       driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("a");
String expectedResult="first name must be more than 2 and less than 64 characters long";
String actualResult=driver.findElement(By.cssSelector("[data-bv-result=INVALID]")).getText();

Assert.assertEquals(expectedResult,actualResult,"input is not true");
    }

    @Test(description = "Verify that the last name must be more than 2 and less than 64 characters long")
    public void test4(){
driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("k");
driver.findElement(By.cssSelector("[data-bv-result=INVALID]")).getText();
String expectedResult="The last name must be more than 2 and less than 64 characters long";
String actualResult=driver.findElement(By.cssSelector("[data-bv-result=INVALID]")).getText();

Assert.assertEquals(expectedResult,actualResult,"Not same warning message");
    }

    @Test(description = "Verify that following success message is displayed")
public void test5(){
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("feride");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("akar");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("feride");
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("ferideakar@hotmail.com");

        driver.findElement(By.cssSelector("[data-bv-field=password]")).sendKeys("123456789");
        driver.findElement(By.cssSelector("[name=\"phone\"]")).sendKeys("469-920-4221");
        driver.findElement(By.cssSelector("[value=female]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"MM/DD/YYYY\"]")).sendKeys("05/02/1974");
        driver.findElement(By.cssSelector("[name=department]")).click();
        driver.findElement(By.cssSelector("[value=DA]")).click();
        driver.findElement(By.cssSelector("[name=job_title]")).sendKeys("QA");
        driver.findElement(By.cssSelector("[for=inlineCheckbox1]")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expectedResult="You've successfully completed registration!";
        driver.findElement(By.tagName("p")).getText();
        String actualResult=driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(expectedResult,actualResult,"You can not see success message");

}

}
