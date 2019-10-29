package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

import static com.cbt.utilities.BrowserFactory.getDriver;
import static com.cbt.utilities.StringUtility.verifyEquals;
import static com.cbt.utilities.BrowserFactory.getDriver;

public class NavigationTests {
    public static void main(String[] args) {


           /* Scanner scan = new Scanner(System.in);
            System.out.println("pick a browser");
            String browser = scan.nextLine();
            if (browser.equals("safari")) {
                WebDriver driver = getDriver("safari");
                driver.navigate().to("http://www.safari.com");
                String actual  = driver.getTitle();
                System.out.println(verifyEquals(actual,"safari" ));
*/
        navigationTest("chrome");
        navigationTest("firefox");
        navigationTest("safari");


    }


    public static void navigationTest (String browser){
        String url1 = "https://google.com";
        String url2 = "https://etsy.com";

        System.out.println("Your browser: " + browser );

        //1. Openbrowser
//        System.getProperty("webdriver.gecko.driver","geckodriver");
//        WebDriver myDriver = new FirefoxDriver();
        WebDriver myDriver = BrowserFactory.getDriver(browser);

        //2. Go to website https://google.com
        myDriver.get(url1);

        //3. Save the title in a string variable
        String title_1 = myDriver.getTitle();

        //4. Go to https://etsy.com
        myDriver.get(url2);

        //5. Save the title in a string variable
        String title_2 = myDriver.getTitle();

        //6. Navigate back to previous page
        myDriver.navigate().back();

        //7. Verify that title is same is in step3
        verifyEquals(title_1, myDriver.getTitle());  // expected result PASS

        //8. Navigate for ward to previous page
        myDriver.navigate().forward();

        //9. Verify that title is same is in step5
        verifyEquals(title_2, myDriver.getTitle());

        myDriver.close();
        myDriver =null;



            }

        }





