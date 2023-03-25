package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class scrollDown {

    private WebDriver driver;

    @BeforeTest
    public void Setup() {
        // se jala de la opcion copy path, path from content root
        //se coloca la direccion del driver
        //System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //se crea la instancia del navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
    }

    @Test
    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");

        Thread.sleep(3000);
        ;

    }


    @AfterTest
    public void tearDown(){
        //cierra el navegador
        driver.close();
        driver.quit();
    }
}
