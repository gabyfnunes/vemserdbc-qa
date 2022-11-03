package br.com.dbccompany.aceitacao;
import br.com.dbccompany.dto.UserLoadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.aceitacao.UserAceitacaoService;
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

        UserLoadDTO resultService = service.adicionarUser(jsonBody);

        Assert.assertEquals(resultService.getUserStatus(), "disponivel");
        Assert.assertEquals(resultService.getId(), 139);

    }

    @Test
    public void testeDeveConsultarUserPeloUserName(){
        String userName = "Gabyfn";

        UserLoadDTO resultService = service.buscarUserPorUserName(userName);

        Assert.assertEquals(resultService.getUsername(), "Gabyfn");
    }

    @Test
    public void testeDeveAtualizarUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user2.json");

        UserLoadDTO resultService = service.atualizarUser(jsonBody);

        Assert.assertEquals(resultService.getUserStatus(), "disponivel");
        Assert.assertEquals(resultService.getId(), 139);

    }

    @Test
    public void testeDeveDeletarPet() {

        String userName = "Gabyfn";

        ResponseDTO responseService = service.deletarUser(userName);

        Assert.assertEquals(responseService.getCode(), "200");
        Assert.assertEquals(responseService.getMessage(), "139");
    }
    @Test
    public void testeLogin() {


    }


}
