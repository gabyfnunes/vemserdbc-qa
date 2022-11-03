package br.com.dbccompany.service;

import br.com.dbccompany.dto.UserLoadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UserService {

    String baseUri = "https://petstore.swagger.io/v2";

    public UserLoadDTO adicionarUser (String requestBody) {

        UserLoadDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post(baseUri + "/user/createWithList")
                        .then()
                        .log().all()
                        .extract().as(UserLoadDTO.class)
                ;
        return result;
    }

    public UserLoadDTO buscarUserPorUserName(String userName){

        UserLoadDTO result =
                given()
                        .log().all()
                        .pathParam("userName", userName)
                .when()
                        .get(baseUri + "/user/{username}")
                .then()
                        .extract().as(UserLoadDTO.class)
                ;
        return result;

    }

    public UserLoadDTO atualizarUser (String requestBody) {

        UserLoadDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                .when()
                        .put(baseUri + "/user/{username}")
                .then()
                        .log().all()
                        .extract().as(UserLoadDTO.class)
                ;
        return result;
    }
    public ResponseDTO deletarUser(String userName) {

        ResponseDTO result =
                given()
                        .pathParam("userName", userName)
                .when()
                        .delete(baseUri + "/user/{username}")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;

        return result;
    }

//    public ResponseDTO login(String userName, String password) {
//
//        ResponseDTO result =
//                given()
//                        .log().all()
//                        .contentType(ContentType.JSON)
//                        .body("{\"username\" : \"Gabyfn\", \"password\" : \"123456\"}")
//                        .when()
//                        .post(baseUri + "/login")
//                        .then()
//                        .log().all()
//                        .statusCode(200)
//                ;
//
//        return result;
//    }
}
