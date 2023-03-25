package Interacciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Interacciones {
    private WebDriver driver;

    @BeforeTest
    public void Setup() {
        // se jala de la opcion copy path, path from content root
        //se coloca la direccion del driver
       // System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //se crea la instancia del navegador
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/");
    }

    @Test
    public void Interacciones() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.clear();
        userName.sendKeys("Manolin");
        userName.clear();
        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
    }

    @AfterTest
    public void tearDown(){
        //cierra el navegador
        driver.close();
    }

}
