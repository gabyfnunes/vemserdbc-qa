package IteraAula1.step;

import IteraAula1.step.BaseTeste;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;


public class TesteCadastro extends BaseTeste {

    Faker faker = new Faker();


    @Test
    public  void cadastrarNovousuario (){
        driver.findElement(By.cssSelector("#FirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("#Surname")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("#E_post")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("#Mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("#Username")).sendKeys(faker.name().username());
        driver.findElement(By.cssSelector("#Username")).sendKeys(faker.name().username());
        String password = faker.internet().password();
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#submit")).click();

        String teste = driver.findElement(By.cssSelector("[class=\"form-horizontal\"]")).getText();

        Assert.assertNotNull(teste);

    }

    @Test
    public  void naoDeveCadastrarNovousuarioCamposNulos (){
        driver.findElement(By.cssSelector("#FirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("#Surname")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("#E_post")).sendKeys(null);
        driver.findElement(By.cssSelector("#Mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("#Username")).sendKeys(faker.name().username());
        driver.findElement(By.cssSelector("#Username")).sendKeys(null);
        String password = faker.internet().password();
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#submit")).click();

        String teste = driver.findElement(By.cssSelector("[class=\"form-horizontal\"]")).getText();

        Assert.assertNull(teste);
        //java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
        //está retornando o erro correto, só não consegui capturá-lo


    }


}
