package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.PetPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.service.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetAceitacaoTest {

    PetService service = new PetService();

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testeDeveAdicionarPet() throws IOException {

        // Massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet1.json");

        // Chamada para o serviço
        PetPayloadDTO resultService = service.adicionarPet(jsonBody);

        // Validar os resultados obtidos
        Assert.assertEquals(resultService.getId(), "19900903");
        Assert.assertEquals(resultService.getName(), "Scooby");
        //assertThat()
    }

    @Test
    public void testeDeveConsultarPetPorId() {

        Integer idPet = 19900903;

        PetPayloadDTO resultService = service.consultarPetPorId(idPet);

        Assert.assertEquals(resultService.getId(), "19900903");
        Assert.assertEquals(resultService.getName(), "Scooby");
    }

    @Test
    public void testeDeveAtualizarPet() throws IOException {

        // Massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet2.json");

        // Chamada para o serviço
        PetPayloadDTO resultBody = service.atualizarPet(jsonBody);

        // Validar os resultados obtidos no retorno
        Assert.assertEquals(resultBody.getId(), "25102022");
        Assert.assertEquals(resultBody.getName(), "Scooby Doo");
        Assert.assertEquals(resultBody.getTags().get(0).getName(), "qa/dev");
    }

    @Test
    public void testeDeveDeletarPet() {

        Integer idPet = 19900903;

        ResponseDTO responseService = service.deletarPet(idPet);

        Assert.assertEquals(responseService.getCode(), "200");
        Assert.assertEquals(responseService.getMessage(), "19900903");
    }
}
