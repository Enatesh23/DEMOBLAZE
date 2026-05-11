package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.CheckOutInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckOutPage extends Base_Class implements CheckOutInterfaceElements {

    @FindBy(linkText = cart_linkText)
    private static WebElement cart;

    @FindBy(xpath = place_order_xpath)
    private static WebElement placeOrder;

    public CheckOutPage() {
        PageFactory.initElements(driver,this);
    }

    public static void checkOut() throws InterruptedException{
        Thread.sleep(2000);
        clickOnElement(cart);
        Thread.sleep(2000);
        clickOnElement(placeOrder);
        Thread.sleep(2000);
    }
}
