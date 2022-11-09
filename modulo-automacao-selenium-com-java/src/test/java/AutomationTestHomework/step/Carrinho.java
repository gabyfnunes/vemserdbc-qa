package AutomationTestHomework.step;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;

public class Carrinho extends BaseTeste{

    Faker faker = new Faker();
    public static void login(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Gaby@teste2022");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }

    @Test
    public void verCarrinho(){
        login();
        driver.findElement(By.cssSelector("#wpmenucartli > a")).click();
    }

    @Test
    public void confirmarCompra(){
        verCarrinho();
        driver.findElement(By.cssSelector("#page-34 > div > div.woocommerce > div > div > div > a")).click();

        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Gabriela");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Freitas");
        driver.findElement(By.cssSelector("#billing_company")).sendKeys("DBC Company");
        driver.findElement(By.cssSelector("#billing_phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.cssSelector("#select2-chosen-1")).click();
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("#billing_city")).sendKeys(faker.address().city());
        driver.findElement(By.cssSelector("#billing_state")).sendKeys(faker.address().state());
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys(faker.address().zipCodeByState(faker.address().stateAbbr()));

        driver.findElement(By.cssSelector("#payment > ul > li.wc_payment_method.payment_method_cod > label")).click();
        driver.findElement(By.cssSelector("#place_order")).click();
    }

}
