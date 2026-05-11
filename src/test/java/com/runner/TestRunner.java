package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.time.Duration;

public class TestRunner extends Base_Class {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        screenshort(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("screenshot"));
        PageObjectManager.getPageObjectManager().getSearchProduct().searchProduct();
        PageObjectManager.getPageObjectManager().getCheckOutPage().checkOut();
        screenshort(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("screenshot"));
        PageObjectManager.getPageObjectManager().getAddressPage().addressPage();
        System.out.println(20);
        System.out.println(20+"tester2");
    }
}