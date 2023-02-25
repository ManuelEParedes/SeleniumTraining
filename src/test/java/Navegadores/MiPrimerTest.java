package Navegadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MiPrimerTest{
    private WebDriver driver;

    @BeforeTest
    public void Setup() {
        // se jala de la opcion copy path, path from content root
        //se coloca la direccion del driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        //se crea la instancia del navegador
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/");
    }
    @Test
    public void MiPrimerTest() throws InterruptedException {
        /*
        WebElement demoSite = driver.findElement(By.id("site-name"));
        demoSite.click();
        Thread.sleep(3000);

        WebElement demoSite = driver.findElement(By.name("userName"));
        demoSite.sendKeys("AutomationTest");
        Thread.sleep(3000);

        WebElement demoSite = driver.findElement(By.linkText("Demo Site"));
        demoSite.click();
        Thread.sleep(3000);

        WebElement demoSite = driver.findElement(By.partialLinkText("Demo"));
        demoSite.click();
        Thread.sleep(3000);

        WebElement demoSite = driver.findElement(By.cssSelector("#site-name"));
        demoSite.click();
        Thread.sleep(3000);

        WebElement demoSite = driver.findElement(By.cssSelector("#site-name"));
        demoSite.click();
        Thread.sleep(3000);
        */
        WebElement demoSite = driver.findElement(By.cssSelector("input[type='text'][name='userName']"));
        demoSite.click();
        demoSite.sendKeys("Manolin");
        Thread.sleep(3000);


    }

    @AfterTest
    public void tearDown(){
        //cierra el navegador
        driver.close();
    }
}
