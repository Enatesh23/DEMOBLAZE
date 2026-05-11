package com.runner;

import com.utility.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelTestRunner {
    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");
        String userName = ReadExcelData.getParticularData(2, 0);
        driver.findElement(By.name("email")).sendKeys(userName);
        String password = ReadExcelData.getParticularData(2, 1);
        driver.findElement(By.name("pass")).sendKeys(password );
    }
}
