package AutomationTestHomework.step;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Orders extends BaseTeste{

    public static void login(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Gaby@teste2022");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }

//    @Test
//    public void quandoNaoHouverPedidos(){
//        login();
//        driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders.is-active > a")).click();
//
////        String validacaoPedidos = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > div > div")).getText();
////        Assert.assertEquals(validacaoPedidos, "No order has been made yet.");
//
//    }
}
