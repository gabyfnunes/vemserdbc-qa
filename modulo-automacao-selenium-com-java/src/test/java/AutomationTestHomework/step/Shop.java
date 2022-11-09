package AutomationTestHomework.step;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Shop extends BaseTeste{

    public static void login(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Gaby@teste2022");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }

    @Test
    public void adcionarProdutoNoCarrinho(){
        login();
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();

        driver.findElement(By.cssSelector("#woocommerce_product_categories-2 > ul > li.cat-item.cat-item-19 > a")).click();
        driver.findElement(By.cssSelector("#content > ul > li.post-182.product.type-product.status-publish.product_cat-html.product_tag-html.has-post-title.no-post-date.has-post-category.has-post-tag.has-post-comment.has-post-author.instock.taxable.shipping-taxable.purchasable.product-type-simple > a.woocommerce-LoopProduct-link > img")).click();
        driver.findElement(By.cssSelector("#product-182 > div.summary.entry-summary > form > button")).click();

        String validacaoAdicionarCarrinho = driver.findElement(By.cssSelector("#content > div.woocommerce-message")).getText();
        Assert.assertNotNull(validacaoAdicionarCarrinho);

    }

    @Test
    public void ordenarProdutos(){
        login();
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();
        driver.findElement(By.cssSelector("#content > form > select")).click();


        driver.findElement(By.cssSelector("[value=\"popularity\"]")).click();
    }
}
