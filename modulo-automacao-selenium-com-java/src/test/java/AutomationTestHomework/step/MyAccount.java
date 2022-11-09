package AutomationTestHomework.step;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyAccount extends BaseTeste{

    @Test
    public void cadastrarUser(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys("Gaby@teste2022");
        driver.findElement(By.cssSelector("[name=\"register\"]")).click();
    }

    @Test
    public void cadastrarUserSemPreencherSenha(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys("gaby@tester2.com");
        driver.findElement(By.cssSelector("[name=\"register\"]")).click();

        String valicaoCadastro = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul")).getText();
        Assert.assertEquals(valicaoCadastro, "Error: Please enter an account password.");
    }

    @Test
    public void cadastrarUserEmailExistente(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys("Gaby@teste2022");
        driver.findElement(By.cssSelector("[name=\"register\"]")).click();

        String validacaoCadastro = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul")).getText();
        Assert.assertEquals(validacaoCadastro, "Error: An account is already registered with your email address. Please login.");
    }

    @Test
    public void login(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Gaby@teste2022");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }

    @Test
    public void loginSenhaIncorreta(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();

        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Gaby@teste2021");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();

        String valicaoCadastro = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul")).getText();
        Assert.assertEquals(valicaoCadastro, "Error: the password you entered for the username gaby@tester.com is incorrect. Lost your password?");

    }

    @Test
    public void esqueceuSenha(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
        driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p.woocommerce-LostPassword.lost_password > a")).click();

        driver.findElement(By.cssSelector("[id=\"user_login\"]")).sendKeys("gaby@tester.com");
        driver.findElement(By.cssSelector("[value=\"Reset Password\"]")).click();

        String validacaoResetSenha = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > div")).getText();
        Assert.assertEquals(validacaoResetSenha,"Password reset email has been sent.");
    }

    @Test
    public void esqueceuSenhaPassandoEmailInexistente(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
        driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p.woocommerce-LostPassword.lost_password > a")).click();

        driver.findElement(By.cssSelector("[id=\"user_login\"]")).sendKeys("gaby@tester254.com");
        driver.findElement(By.cssSelector("[value=\"Reset Password\"]")).click();

        String validacaoResetSenha = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul")).getText();
        Assert.assertEquals(validacaoResetSenha,"Invalid username or e-mail.");
    }
}
