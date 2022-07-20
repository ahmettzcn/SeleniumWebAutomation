import org.checkerframework.checker.units.qual.C;
import pages.*;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;


public class tBaseTest extends BaseTest {


    @Test
    public void testingScenario(){
        homePage.setSearchField("roman");//arama kutusuna roman kelimesini yazar.
        SearchPage searchPage = homePage.clickSearchButton();//Arama butonuna basarak arama kutusuna girilmiş olan roman kelimesini aratır.
        ProductPage productPage = searchPage.selectProduct();// roman kategorisinden rastgele bir kitap seçer.
        productPage.clickAddToBasket();//seçilen ürünün sayfasında sepete ekle butonuna basar.
        BasketPage basketPage = productPage.clickBasketPage();//sepete gider.
        basketPage.setIncreaseProduct("2");//ürünün miktarı arttırılır.
        basketPage.clickOnRefreshBtn();//yenile butonuna basılır.
        //basketPage.assertRefreshStatus();
        basketPage.clickOnDelProductBtn();//ürünü sepetten siler.
        basketPage.assertBasketStatus();//sepeti kontrol eder.
    }
}
