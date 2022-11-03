package br.com.dbccompany.service;


import br.com.dbccompany.dto.PetPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PetService {

    // Especificar a baseUri
    String baseUri = "https://petstore.swagger.io/v2";

    public PetPayloadDTO adicionarPet(String requestBody) {

        PetPayloadDTO result =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
        .when()
                .post(baseUri + "/pet")
        .then()
                .log().all()
                .extract().as(PetPayloadDTO.class)
        ;
        return result;
    }

    public PetPayloadDTO consultarPetPorId(Integer idPet) {

        PetPayloadDTO result =
        given()
                .log().all()
                .pathParam("idPet", idPet)
        .when()
                .get(baseUri + "/pet/{idPet}")
        .then()
                .extract().as(PetPayloadDTO.class)
        ;
        return result;
    }

    public PetPayloadDTO atualizarPet(String jsonBody) {

        // REST-Assured
        PetPayloadDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                        .when()
                        .put(baseUri + "/pet")
                        .then()
                        .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO deletarPet(Integer idPet) {

        ResponseDTO result =
        given()
                .pathParam("idPet", idPet)
        .when()
                .delete(baseUri + "/pet/{idPet}")
        .then()
                .log().all()
                .extract().as(ResponseDTO.class)
        ;

        return result;
    }
}
