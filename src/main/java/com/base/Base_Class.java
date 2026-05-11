package com.base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Base_Class {
    public static WebDriver driver;

    protected static void launchBrowser(String browser) {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING LAUNCHING THE BROWSER");
        }
        driver.manage().window().maximize();
    }

    protected static void launchUrl(String url) {
        try {
            driver.get(url);

        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING LAUNCHING THE URL");
        }
    }

    protected static void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING CLICKING THE ELEMENT");
        }
    }

    protected static void scroll(WebDriver driver, WebElement element, String type) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            switch (type.toLowerCase()) {

                case "element":
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    break;

                case "bottom":
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                    break;

                case "top":
                    js.executeScript("window.scrollTo(0, 0);");
                    break;

                case "down":
                    js.executeScript("window.scrollBy(0, 500);");
                    break;

                case "up":
                    js.executeScript("window.scrollBy(0, -500);");
                    break;

                default:
                    System.out.println("Invalid scroll type");
            }

        } catch (Exception e) {
            Assert.fail("ERROR DURING SCROLL");
        }
    }


    protected static void passingInput(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING PASSING THE INPUT");
        }
    }

    protected static void browserTermination() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING TERMINATE THE BROWSER");
        }
    }

    protected static void closingSession() {
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING TERMINATE THE BROWSER");
        }
    }


    protected static void windowsHandling(int number) {
        try {
            List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(allWindow.get(number));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING THE WINDOW HANDLE");
        }
    }

    protected static void selectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("TEXT")) {
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("INDEX")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("VALUE")) {
                select.selectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING VALUE SELECTION");
        }
    }

    protected static void deSelectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("TEXT")) {
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("INDEX")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("VALUE")) {
                select.deselectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING VALUE SELECTION");
        }
    }

    protected static void getText(WebElement element) {
        try {
            String text = element.getText();
            System.out.println(text);

        } catch (Exception e) {

            Assert.fail("ERROR OCCUR DURING TEXT GETTING");
        }
    }

    protected static void screenshort(String location) {
        try {
            Date currentDate = new Date();
            System.out.println(currentDate);
            String dateFile = currentDate.toString().replace(" ", "_").replace(":", "_");
            System.out.println(dateFile);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File(location + dateFile + ".png"));

        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING SCREENSHORT");
        }
    }

    protected static void getAttribute(WebElement element) {
        try {
            String text = element.getText();
            System.out.println(text);
        } catch (Exception e) {

            Assert.fail("ERROR OCCUR DURING FETCH THE ATTRIBUTE");
        }
    }

    protected static void navigateTo(String url) {
        try {
            driver.navigate().to(url);

        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING THE NAVIGATION OTHER URL");
        }
    }

    protected static void navigateAction(String action) {
        try {
            if (action.equalsIgnoreCase("back")) {
                driver.navigate().back();

            } else if (action.equalsIgnoreCase("forward")) {
                driver.navigate().forward();

            } else if (action.equalsIgnoreCase("refresh")) {
                driver.navigate().refresh();
            }

        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING NAVIGATING ACTION ");
        }

    }

    protected static void handleAlert(String action) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                    // Wait until alert appears
                    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

                    // Get and print alert text
                    String message = alert.getText();
                    System.out.println("Alert Message: " + message);

                    // Perform action
                    if (action.equalsIgnoreCase("accept")) {
                        alert.accept();
                    } else if (action.equalsIgnoreCase("dismiss")) {
                        alert.dismiss();
                    }

                } catch (Exception e) {
                    System.out.println("No alert present or error occurred: " + e.getMessage());
                }
            }

    protected static void getTitle() {
        try {
            String title = driver.getTitle();
            System.out.println(title);

        } catch (Exception e) {

            Assert.fail("ERROR OCCUR DURING FETCHING THE TITLE");
        }
    }

    protected static void getCurrentUrl() {
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);

        } catch (Exception e) {

            Assert.fail("ERROR OCCUR DURING FETCHING THE URL");
        }
    }

    protected static void isEnabled(WebElement element) {
        try {
            boolean status = element.isEnabled();
            System.out.println("Element is enabled or not?:" + status);
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING CHECKING THE ENABLE STATUS");
        }
    }

    protected static void isDisplayed(WebElement element) {
        try {
            boolean status = element.isDisplayed();
            System.out.println("Element is Displayed or not?:" + status);
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING CHECKING THE DISPLAY STATUS");
        }
    }

    protected static void isSelected(WebElement element) {
        try {
            boolean status = element.isSelected();
            System.out.println("Element is Selected or not?:" + status);
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR DURING CHECKING THE SELECT STATUS");
        }
    }

    protected static void implicitWait(int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR WHILE WAITING FOR ELEMENT VISIBILITY");
        }
    }

    protected static void frameAction(String id) {
        try {
            driver.switchTo().frame(id);
        } catch (Exception e) {
            Assert.fail("ERROR OCCUR WHILE SWITCHING TO THE FRAME");
        }
    }
}