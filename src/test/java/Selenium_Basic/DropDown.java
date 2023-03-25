package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class DropDown {
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
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    @Test
    public void DropDownWithClick() throws InterruptedException {
        WebElement selectDay = driver.findElement(By.className("form-control"));
        selectDay.click();
        Thread.sleep(3000);
        String day = "Saturday";
        String opcionBuscar = String.format("//option[text()='%s']", day);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        option.click();
        Thread.sleep(3000);
    }

    @Test
    public void DropDownWithSendKeys() throws InterruptedException {
        WebElement selectDay = driver.findElement(By.className("form-control"));
        String day = "Friday";
        selectDay.sendKeys(day);
        Thread.sleep(3000);

    }

    @Test
    public void DropDownWithClasesSelect() throws InterruptedException {
        WebElement selectDay = driver.findElement(By.className("form-control"));
        String day = "Monday";
        Select selectList = new Select(selectDay);
        selectList.selectByVisibleText(day);
        Thread.sleep(3000);
        selectList.selectByValue("Tuesday");
        Thread.sleep(3000);
        selectList.selectByIndex(4);
        Thread.sleep(3000);
    }

    @Test
    public void DropDownWithClasesSelectRandom() throws InterruptedException {
        WebElement selectDay = driver.findElement(By.className("form-control"));
        Select selectList = new Select(selectDay);
        Random i = new Random();
        int index = i.nextInt(0,7);
        System.out.println("El indice es = " + index);
        selectList.selectByIndex(index);
        Thread.sleep(3000);
    }



        @AfterTest
    public void tearDown(){
        //cierra el navegador
        driver.close();
        driver.quit();
    }
}
