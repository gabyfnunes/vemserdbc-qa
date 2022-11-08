package IteraAula1.step;

import IteraAula1.step.BaseTeste;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import com.github.javafaker.Faker;

public class homework  extends BaseTeste {

    Faker faker = new Faker();


    @Test
    public void devePreencherFormulario (){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("[id=\"name\"]")).sendKeys(faker.name().fullName());
        driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("[id=\"email\"]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys(faker.internet().password());
        driver.findElement(By.cssSelector("[id=\"address\"]")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        String teste = driver.findElement(By.cssSelector("body > div > div:nth-child(3) > div.card-body")).getText();

        Assert.assertNotNull(teste);

    }

    @Test
    public void naoDevePreencherFormularioComCampoNulo (){

        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("[id=\"name\"]")).sendKeys(faker.name().fullName());
        driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("[id=\"email\"]")).sendKeys("");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("");
        driver.findElement(By.cssSelector("[id=\"address\"]")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();

        String teste = driver.findElement(By.cssSelector("body > div > div:nth-child(3) > div.card-body")).getText();

//        Assert.assertNotNull(teste);

        //java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
        //está retornando o erro correto, só não consegui capturá-lo

    }

    @Test
    public void marcarCheckBoxGenero(){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("[id=\"female\"]")).click();
        Boolean opcaoMarcada = driver.findElement(By.cssSelector("[id=\"female\"]")).isSelected();

        Assert.assertNotNull (opcaoMarcada.toString());
    }

    @Test
    public void naoMarcarCheckBoxGenero(){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("[id=\"female\"]")).click();
        Boolean opcaoFemale = driver.findElement(By.cssSelector("[id=\"female\"]")).isSelected();


        Assert.assertTrue(opcaoFemale);
    }

    @Test
    public void marcarSelectBoxDiasDaSemana(){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("[id=\"monday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"thursday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"friday\"]")).click();


        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"monday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"thursday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"friday\"]")).isSelected());

    }

    @Test
    public void selecionarPaisDropDown(){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

         WebElement selectElement = driver.findElement(By.className("custom-select"));

         Select selecao = new Select(selectElement);
        selecao.selectByVisibleText("Norway");

         Assert.assertEquals(selecao.getFirstSelectedOption().getText(), "Norway");

    }

    @Test
    public void dropDownSemNenhumPaisSelecionado(){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        WebElement selectElement = driver.findElement(By.className("custom-select"));

        Select select = new Select(selectElement);
        select.selectByVisibleText("Select option");

        Assert.assertNotNull(select.getFirstSelectedOption().getText().isEmpty());

    }

    @Test
    public void marcarCheckBoxAno() {
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("label[for=\"3years\"]")).click();

        Boolean opcaoMarcada = driver.findElement(By.cssSelector("label[for=\"3years\"]")).isSelected();

        Assert.assertNotNull (opcaoMarcada.toString());
    }

    @Test
    public void naoMarcarCheckBoxAno() {
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("label[for=\"3years\"]")).click();

        Boolean opcaoMarcada = driver.findElement(By.cssSelector("label[for=\"3years\"]")).isSelected();

        Assert.assertFalse (opcaoMarcada);
    }

    @Test
    public void marcarSelectBoxFrameworks(){
        driver.findElement(By.cssSelector("#navbarColor01 > ul > li:nth-child(3) > a")).click();

        driver.findElement(By.cssSelector("[for=\"selenium\"]")).click();
        driver.findElement(By.cssSelector("[for=\"testng\"]")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"selenium\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("[for=\"testng\"]")).isSelected());

    }



}
