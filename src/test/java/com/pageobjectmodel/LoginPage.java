package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.LoginInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends Base_Class implements LoginInterfaceElements {
    @FindBy(linkText = login_linkText)
    private static WebElement login;

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy(css = password_css)
    private static WebElement password;

    @FindBy(xpath = signin_xpath)
    private static WebElement signin;

    @FindBy(xpath = text_xpath)
    private static WebElement title;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public static void validLogin() throws InterruptedException
    {
        clickOnElement(login);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        passingInput(username,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
        passingInput(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        clickOnElement(signin);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        getText(title);
    }
}
