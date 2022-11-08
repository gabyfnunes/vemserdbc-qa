package IteraAula1.step;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login extends BaseTeste {

    public static WebDriver driver;



    @Test
    public void validarLoginComUsernameSenhaValidos(){
        // Informando a automação qual app vai utilizar


        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys("teste123");
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();



    }


}
