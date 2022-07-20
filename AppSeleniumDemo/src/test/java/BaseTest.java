import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;


public class BaseTest {
    private static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmet\\IdeaProjects\\AppSeleniumDemo\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        String title = driver.getTitle();
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        Assert.assertEquals(expectedTitle, title);//AnaSayfa'yı kontrol eder.
        homePage = new HomePage(driver);
        driver.manage().window().maximize();//web browserı büyük pencere yapar.
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();//kapatır.
    }
}
