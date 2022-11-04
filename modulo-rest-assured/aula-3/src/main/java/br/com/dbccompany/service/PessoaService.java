package br.com.dbccompany.service;

import br.com.dbccompany.dto.RelatorioDTO;
import br.com.dbccompany.utils.Login;

import static io.restassured.RestAssured.*;

public class PessoaService {

    String baseUri = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";

    //String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX01BUktFVElORyIsIlJPTEVfVVNVQVJJTyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY3NDk3MjMxLCJleHAiOjE2Njc1ODM2MzF9.QczfEGTXZzDMOFaQUXSs7TlByGauSzImwzW9Kqs4vzs";

    String tokenAdm = new Login().autenticacaoAdmin();

    public RelatorioDTO[] buscarRelatorio() {

        // obter o Relatório
        RelatorioDTO[] result =
        given()
                .log().all()
                .header("Authorization", tokenAdm)
        .when()
                .get(baseUri + "/pessoa/relatorio")
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(RelatorioDTO[].class)
        ;
        return result;
    }
}
