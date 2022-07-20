package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By selectProduct = By.className("product-cr");

    public SearchPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public ProductPage selectProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(selectProduct));
        driver.findElement(selectProduct).click();
        return new ProductPage(driver);
    }
}
