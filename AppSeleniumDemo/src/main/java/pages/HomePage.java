package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchField = By.id("search-input");
    private By searchBtn = By.className("button-search");

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void setSearchField(String word){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchField));
        driver.findElement(searchField).sendKeys(word);
    }
    public SearchPage clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        driver.findElement(searchBtn).click();
        return new SearchPage(driver);
    }
}
