package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.Firefox.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.Edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser Name");
        }
        driver.get(baseUrl); //open Url
        driver.manage().window().maximize(); //maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit time

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println("page title is : " + title);

        // Get Current URL
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //Get Page Sourcecode
        System.out.println("page source: " + driver.getPageSource());

        //Navigate to login page by clicking on login Link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Find the Email Field element and send the email
        WebElement emailField = driver.findElement(By.id("username"));

        //type email to email field
        emailField.sendKeys("Admin");

        //Find the Password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("admin123");

        driver.quit(); //close the browser


    }
}


