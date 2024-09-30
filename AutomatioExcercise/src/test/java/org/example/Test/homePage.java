package org.example.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class homePage {
    public static void main(String[] args) throws InterruptedException {
        //set the executable property of the chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Automation excercise");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);
        //to maximize the page
        driver.manage().window().maximize();
        //lunch browser
        //to navigate to web page, driver.navigate() or driver.get()
        driver.get("https://www.automationexercise.com/");



    }
}
