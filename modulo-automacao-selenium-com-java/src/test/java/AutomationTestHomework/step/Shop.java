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
    public void adcionarProdutoIndisponivelNoCarrinho(){
        login();
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();

        driver.findElement(By.cssSelector("#content > ul > li.post-169.product.type-product.status-publish.product_cat-android.product_tag-android.has-post-title.no-post-date.has-post-category.has-post-tag.has-post-comment.has-post-author.first.outofstock.sale.downloadable.taxable.shipping-taxable.purchasable.product-type-simple > a.button.product_type_simple.ajax_add_to_cart")).click();


        String validacaoAdicionarCarrinho = driver.findElement(By.cssSelector("#product-169 > div.summary.entry-summary > p")).getText();
        Assert.assertEquals(validacaoAdicionarCarrinho, "Out of stock");
    }

    @Test
    public void ordenarProdutos(){
        login();
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();
        driver.findElement(By.cssSelector("#content > form > select")).click();


        driver.findElement(By.cssSelector("[value=\"popularity\"]")).click();

        String validacaoOrdemPopular = driver.findElement(By.cssSelector("#content > ul > li.post-160.product.type-product.status-publish.product_cat-selenium.product_tag-ruby.product_tag-selenium.has-post-title.no-post-date.has-post-category.has-post-tag.has-post-comment.has-post-author.first.instock.downloadable.taxable.shipping-taxable.purchasable.product-type-simple > a.woocommerce-LoopProduct-link > h3")).getText();
        Assert.assertEquals(validacaoOrdemPopular, "Selenium Ruby");
    }

    @Test
    public void selecionarPorCategoria(){
        login();
        driver.findElement(By.cssSelector("#menu-item-40 > a")).click();
        driver.findElement(By.cssSelector("#woocommerce_product_categories-2 > ul > li.cat-item.cat-item-19")).click();


        String validacaoCategoria = driver.findElement(By.cssSelector("#content > nav")).getText();
        Assert.assertEquals(validacaoCategoria, "Home / Shop");

    }
}
