package IteraAula1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import com.github.javafaker.Faker;


public class TesteCadastro {
    public static WebDriver driver;
    public static WebDriverWait wait;

    Faker faker = new Faker();

    @Before
    public void abrirNavegador() {
        // Informando a automação qual app vai utilizar
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);

        // Abrir navegador = .get
        driver.get("https://itera-qa.azurewebsites.net/UserRegister/NewUser");
        // Maximar
        driver.manage().window().maximize();
        // daley
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @After
    public void fecharNavegador() {
        // Informando a automaçãoal app vai utilizar
        driver.quit();
    }
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
