package IteraAula2.step;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class CRUD extends BaseTeste {

    Faker faker = new Faker();

    public static void login(){
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();

        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys("teste123");
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }


    @Test
    public void criarNovaPessoa(){
        login();
        driver.findElement(By.cssSelector("body > div > div > p:nth-child(4) > a")).click();


        driver.findElement(By.cssSelector("[id=\"Name\"]")).sendKeys("Regina Phalange");
        String empresa = faker.company().name();
        driver.findElement(By.cssSelector("[id=\"Company\"]")).sendKeys(empresa);
        String endereco = faker.address().fullAddress();
        driver.findElement(By.cssSelector("[id=\"Address\"]")).sendKeys(endereco);
        String cidade = faker.address().city();
        driver.findElement(By.cssSelector("[id=\"City\"]")).sendKeys(cidade);
        String telefone = faker.phoneNumber().cellPhone();
        driver.findElement(By.cssSelector("[id=\"Phone\"]")).sendKeys(telefone);
        String email = faker.internet().emailAddress();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys(email);

        String formulario = driver.findElement(By.cssSelector("body > div > form > div")).getText();

        Assert.assertNotNull(formulario);

        driver.findElement(By.cssSelector("[value=\"Create\"]")).click();
    }
    @Test
    public void criarNovaPessoaComCamposNulos(){
        //SUGESTÃO DE MELHORIA: FORMULÁRIO NÃO DEVERIA ADICIONAR NOVA PESSOA QUANDO ALGUM CAMPO ESTÁ VAZIO.
        login();
        driver.findElement(By.cssSelector("body > div > div > p:nth-child(4) > a")).click();


        driver.findElement(By.cssSelector("[id=\"Name\"]")).sendKeys("Regina Phalange");
        driver.findElement(By.cssSelector("[id=\"City\"]")).sendKeys(faker.address().city());
        driver.findElement(By.cssSelector("[id=\"Phone\"]")).sendKeys(faker.phoneNumber().cellPhone());

        //Asserts dos Campos propositalmente não preenchidos:
        String verificacaoEmpresa = driver.findElement(By.cssSelector("[id=\"Company\"]")).getText();
        Assert.assertTrue(verificacaoEmpresa.isEmpty());

        String verificacaoEmail = driver.findElement(By.cssSelector("[id=\"Email\"]")).getText();
        Assert.assertTrue(verificacaoEmail.isEmpty());

        String verificacaoEndereco = driver.findElement(By.cssSelector("[id=\"Address\"]")).getText();
        Assert.assertTrue(verificacaoEndereco.isEmpty());

        driver.findElement(By.cssSelector("[value=\"Create\"]")).click();

    }

    @Test
    public void buscarPessoa(){
        login();
        driver.findElement(By.cssSelector("[id=\"searching\"]")).sendKeys("Regina Phalange");
        driver.findElement(By.cssSelector("[value=\"Search\"]")).click();

        String verificacaoBusca = driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1)")).getText();
        Assert.assertEquals(verificacaoBusca, "Regina Phalange");

    }

    @Test
    public void buscarPessoaNaoCadastrada(){
        login();

        driver.findElement(By.cssSelector("[id=\"searching\"]")).sendKeys("Taylor Swift");
        driver.findElement(By.cssSelector("[value=\"Search\"]")).click();

        String teste = driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td")).getText();

        Assert.assertEquals(teste, "No Match");

    }

    @Test
    public void mostrarDetalhes(){
        buscarPessoa();

        driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-info")).click();

        String verificacaoDetalhe = driver.findElement(By.cssSelector("body > div > div > dl > dd:nth-child(2)")).getText();
        Assert.assertEquals(verificacaoDetalhe, "Regina Phalange");

    }

    @Test
    public void editarPessoa(){
        buscarPessoa();
        driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary")).click();

        driver.findElement(By.cssSelector("[id=\"Company\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Company\"]")).sendKeys("DBC COMPANY");
        driver.findElement(By.cssSelector("[id=\"Email\"]")).clear();
        driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys("reg.phalange@email.com");
        driver.findElement(By.cssSelector("[value=\"Save\"]")).click();

        mostrarDetalhes();

    }

    @Test
    public  void deletarPessoa(){
        buscarPessoa();
        driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger")).click();
        driver.findElement(By.cssSelector("[value=\"Delete\"]")).click();

    }



}
