package com.cbt.tests.HomeworkTestNG;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7$12 {
    private WebDriver driver;


    @Test
    public void test6() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");

        driver.get("https://www.tempmailaddress.com/");
        WebElement email = driver.findElement(By.cssSelector("[class=\"animace\"]"));
        String mail = email.getText();
        System.out.println(mail);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("zlfy");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("wooden_spoon")).click();
        WebElement element = driver.findElement(By.name("signup_message"));
        String expectedMesaage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertTrue(element.isDisplayed(), expectedMesaage);
        BrowserUtils.wait(4);
        driver.navigate().to("https://www.tempmailaddress.com/");
        WebElement receivedEmail = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        Assert.assertTrue(receivedEmail.isDisplayed(), "do-not-reply@practice.cybertekschool.com");
        receivedEmail.click();
        WebElement message = driver.findElement(By.id("predmet"));
        String expected = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertTrue(message.isDisplayed(), expected);
        driver.quit();
    }
    @Test
    public void test7(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile =driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/ferideakar/Desktop/Cybertek/School/-/Learn_files/primitive/data/types.jpg");

        driver.findElement(By.id("file-submit")).click();
        WebElement FileName = driver.findElement(By.id("uploaded-files"));
        //Verify that uploaded file name is displayed
        String actualFileName = FileName.getText();
        String expectedFileName = "testFile.txt";
        Assert.assertEquals(actualFileName, expectedFileName, "File name do not match");
        Assert.assertTrue(FileName.isDisplayed(), "File Name is not displayed");

        driver.quit();
    }

    @Test(description = "Verify that you selected: United States Of America")
    public void test8(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
driver.findElement(By.cssSelector("[value=Submit]")).click();

String expectedResult="You selected: United States of America";
String actualResult=driver.findElement(By.id("result")).getText();

Assert.assertEquals(expectedResult,actualResult,"you can not select the right country");

    }

}