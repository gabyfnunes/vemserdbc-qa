package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.UserLoadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.service.UserService;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class UserAceitacaoService {
    UserService service = new UserService();

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void testeDeveAdicionarUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user1.json");

        ResponseDTO resultBody = service.adicionarUser(jsonBody);

        Assert.assertEquals(resultBody.getCode(), "200");

    }

    @Test
    public void testeDeveConsultarUserPeloUserName() throws IOException{
        String userName = "Gabyfn";

        UserLoadDTO resultService = service.buscarUserPorUserName(userName);

        Assert.assertEquals(resultService.getUsername(), "Gabyfn");
        Assert.assertEquals(resultService.getId(), "125778");
    }

    @Test
    public void testeDeverConsultarUserInexistente() throws IOException{
        String userName = "GabyfL";

        ResponseDTO resultService = service.buscarUserInexistente(userName);

        Assert.assertEquals(resultService.getMessage(), "User not found.");

    }

    @Test
    public void testeDeveAtualizarUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user2.json");

        ResponseDTO resultService = service.atualizarUser(jsonBody, "Gabyfng");

        Assert.assertEquals(resultService.getCode(), "200");

    }
    @Test
    public void testeLogin() throws IOException{

        ResponseDTO resultService = service.logarUser("Gabyfn", "123456");

        Assert.assertEquals(resultService.getCode(), "200");
    }
    @Test
    public void testeLoginUserInvalido() throws IOException{

        ResponseDTO resultService = service.logarUserInvalido("Gabyfn", "325486");

        Assert.assertEquals(resultService.getCode(), "400");
    }

    @Test
    public void testeLogout() throws IOException{

        ResponseDTO resultService = service.logoutUser();

        Assert.assertEquals(resultService.getCode(), "200");
    }
    @Test
    public void testeDeveDeletarUser() {

        String userName = "Gabyfng";

        ResponseDTO resultService = service.deletarUser(userName);
        ;

        Assert.assertEquals(resultService.getMessage(), "User not found");
        Assert.assertEquals(resultService.getCode(), "200");
    }


}
