package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class DragAndDrop {

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
    public void DragAndDropActions() throws InterruptedException {

        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(drag,drop).build().perform();
        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDown(){
        //cierra el navegador
        driver.close();
        driver.quit();
    }
}
