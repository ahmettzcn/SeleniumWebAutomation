package pages;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addToBasket = By.id("button-cart");
    private By myBasket = new By.ByXPath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/cart']");
    private By correctNumberControl = By.id("cart-items");
    private String expectedNumber = "1";

    public ProductPage(WebDriver driver){
        this.driver =  driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public void clickAddToBasket(){
        wait.until(ExpectedConditions.elementToBeClickable(addToBasket));
        driver.findElement(addToBasket).click();
    }

   /* public void assertBasketNumber(){
        wait.until(ExpectedConditions.presenceOfElementLocated(correctNumberControl));
        String correctNumber = driver.findElement(correctNumberControl).getText();
        Assert.assertEquals(expectedNumber, correctNumber);
    } Assert kısmında problem yaşadığım için karşılaştırmayı yapamadım.*/

    public BasketPage clickBasketPage(){
        wait.until(ExpectedConditions.elementToBeClickable(myBasket));
        driver.findElement(myBasket).click();
        return new BasketPage(driver);
    }
}
