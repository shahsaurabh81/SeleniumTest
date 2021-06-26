package sampleapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class seleniumTest {

    WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\saushah\\Downloads\\chromedriver.exe");

        String downloadFilepath = "C:\\download\\";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/elements");

    }

//Task-1:
    @Test
    public void task1() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"item-7\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"downloadButton\"]")).click();

    }

//Task-2:
    @Test
    public void task2() {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"item-1\"]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String result = driver.findElement(By.xpath("//*[@id=\"result\"]/span[1]")).getText();
            System.out.println("result: " + result);
            Assert.assertTrue("You have selected 'Home' folder", result.contains("You have selected"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

//Task3:

    @Test
    public void task3() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"item-0\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("User_Name");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("User_Email");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("User_Address");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// or any locator strategy that you find suitable
        WebElement locOfCurrentAddress = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(locOfCurrentAddress).doubleClick().build().perform();

// catch here is double click on the text will by default select the text
// now apply copy command
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys(Keys.chord(Keys.CONTROL,"c"));

// now apply the command to paste
        driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void quit(){
        driver.quit();
    }

}
