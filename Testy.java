package PracaDomowa;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Testy {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/lukas/Downloads/chromedriver_win32/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://onet.pl/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        Assert.assertEquals(driver.getTitle(), "Onet – Jesteś na bieżąco");
    }

    @Test
    public void test2() {
        driver.findElement(By.xpath("//*[@id=\"tabMenu\"]/div/ul/li[4]/a")).click(); //klikniecie w 'regionalne'
        driver.findElement(By.xpath("//*[@id=\"tabMenu\"]/div/ul/li[4]/div/ul/ul[3]/li[1]/a")).click(); //wybor konkretnego regionu z rozwijalnej listy
    }

    @Test
    public void test3() {
        driver.findElement(By.xpath("//*[@id=\"menuIconMail\"]/path")).click();

        WebElement mailFormLogin = driver.findElement(By.id("mailFormLogin"));
        mailFormLogin.sendKeys("katarzyna");

        WebElement mailFormPassword = driver.findElement(By.id("mailFormPassword"));
        mailFormPassword.sendKeys("123456789");

        WebElement accept = driver.findElement(By.className("loginButton"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        accept.click();
    }

    @Test
    public void test4() {
        driver.findElement(By.xpath("//*[@id=\"tabMenu\"]/div/ul/li[1]/a")).click();

        Set<String> windows = driver.getWindowHandles();

        String currentWindow = driver.getWindowHandle();
        for (String nextWindow : windows) {
            if (driver.switchTo().window(nextWindow).getTitle().equalsIgnoreCase("Onet – Jesteś na bieżąco")) {
                break;
            } else {
                driver.switchTo().window(currentWindow);
            }
        }
        Assert.assertEquals(driver.getTitle(), "Onet – Jesteś na bieżąco");
    }
}
