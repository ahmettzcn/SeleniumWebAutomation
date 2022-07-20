package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By increaseProduct = By.xpath("//input[@name='quantity']");
    private By refreshBtn = By.xpath("//i[@title='Güncelle']");
    private By refreshStatus = By.className("swal-toast");
    String expectedRefreshStatus = "Sepetiniz güncelleniyor!";
    private By delProductBtn = By.xpath("//i[@title='Kaldır']");
    private By basketStatus = By.xpath("//div[@class='content']");
    String expectedBasketStatus = "Sepetinizdeki ürünleri görmek için üye girişi yapmanız gerekmektedir.";
    public BasketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void setIncreaseProduct(String number){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(increaseProduct));
        driver.findElement(increaseProduct).click();
        driver.findElement(increaseProduct).clear();
        driver.findElement(increaseProduct).sendKeys(number);
    }

    public void clickOnRefreshBtn(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(refreshBtn));
        driver.findElement(refreshBtn).click();
    }

    /*public void assertRefreshStatus(){
        wait.until(ExpectedConditions.presenceOfElementLocated(refreshStatus));
        Assert.assertTrue(expectedRefreshStatus.contains(driver.findElement(refreshStatus).getText()));
    }*/
    public void clickOnDelProductBtn(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(delProductBtn));
        driver.findElement(delProductBtn).click();
    }

    public void assertBasketStatus(){
        wait.until(ExpectedConditions.presenceOfElementLocated(basketStatus));
        Assert.assertTrue(expectedBasketStatus.contains(driver.findElement(basketStatus).getText()));
        System.out.println("sepetin boş olduğu kontrol edildi.");
    }
}
