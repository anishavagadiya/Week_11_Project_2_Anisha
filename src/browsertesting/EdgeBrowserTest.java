package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTest {

    public static void main(String[] args) {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //open Url
        driver.get(baseUrl);
        driver.manage().window().maximize(); //maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit time

        //Print title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        //Print current Url
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //Print page source
        System.out.println("page source is: " + driver.getPageSource());

        //Enter Email to Email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        //Enter the password to password field
        WebElement passwordfield = driver.findElement(By.name("password"));
        passwordfield.sendKeys("admin123");

        //Close the browser
        driver.quit();

    }
}
