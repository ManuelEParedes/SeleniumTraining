package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChekBox {

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
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    //Validar
    //Verificar que se muestre el elemento con el cual se va a interactuar
    //Verificar que los radio button esten habilitados
    //Verificar que se efectue la seleccion
    @Test
    public void ChekBox() throws InterruptedException {
        WebElement radioMale1 = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
        WebElement radioFemale1 = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
        WebElement radioMale2 = driver.findElement(By.xpath("//input[@value='Male' and @name='gender']"));
        WebElement radioFemale2 = driver.findElement(By.xpath("//input[@value='Female' and @name='gender']"));

        //is Displayed regresa un valor booleano, si está presente
        boolean displayedM = radioMale1.isDisplayed();
        System.out.println("DisplayedM = " + displayedM);
        boolean displayedF = radioFemale1.isDisplayed();
        System.out.println("DisplayedF = " + displayedF);
        radioMale1.click();
        Thread.sleep(3000);
        radioFemale1.click();
        Thread.sleep(3000);
        //inEnable nos regresa un valor booleano, si está habilitado
        boolean enableM = radioMale2.isDisplayed();
        System.out.println("EnableM = " + enableM);
        boolean enableF = radioFemale2.isDisplayed();
        System.out.println("EnableF = " + enableF);
        radioMale2.click();
        Thread.sleep(3000);
        radioFemale2.click();
        Thread.sleep(3000);
        //isSelected, booleano si está seleccionado
        boolean SelectedM1 = radioMale1.isSelected();
        System.out.println("SelectedM1 = " + SelectedM1);
        boolean SelectedF1 = radioFemale1.isSelected();
        System.out.println("SelectedF1 = " + SelectedF1);
        boolean SelectedM2 = radioMale1.isSelected();
        System.out.println("SelectedM2 = " + SelectedM2);
        boolean SelectedF2 = radioFemale1.isSelected();
        System.out.println("SelectedF2 = " + SelectedF2);
    }


    @AfterTest
    public void tearDown(){
        //cierra el navegador
        driver.close();
    }
}
