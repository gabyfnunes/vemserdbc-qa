package br.com.dbccompany.service;

import br.com.dbccompany.dto.UserLoadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;

import java.io.IOException;

import static io.restassured.RestAssured.*;


public class UserService {

    String baseUri = "https://petstore.swagger.io/v2";

    public ResponseDTO adicionarUser(Object jsonBody) {

        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                        .when()
                        .post(baseUri + "/user")
                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class);
        return result;
    }

    public UserLoadDTO buscarUserPorUserName(String userName) {
        UserLoadDTO result =
                given()
                        .log().all()
                        .pathParam("userName", userName)
                        .when()
                        .get(baseUri + "/user/{userName}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().as(UserLoadDTO.class);
        return result;
    }

    public ResponseDTO buscarUserInexistente(String userName) {
        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("userName", userName)
                        .when()
                        .get(baseUri + "/user/{userName}")
                        .then()
                        .log().all()
                        .statusCode(404)
                        .extract().as(ResponseDTO.class);
        return result;
    }

    public ResponseDTO atualizarUser(String requestBody, String userName) {

        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                .when()
                        .put(baseUri + "/user/" + userName)
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class);
        return result;
    }

    public ResponseDTO deletarUser(String userName) {

        ResponseDTO result =
                given()
                        .pathParam("userName", userName)
                        .when()
                        .delete(baseUri + "/user/{userName}")
                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO logarUser(String userName, String password) throws IOException {

        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("username", userName)
                        .pathParam("password", password)
                        .when()
                        .get(baseUri + "/user/login?username={username}&password={password}")
                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO logarUserInvalido(String userName, String password) throws IOException {

        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("username", userName)
                        .pathParam("password", password)
                        .when()
                        .get(baseUri + "/user/login?username={username}&password={password}")
                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO logoutUser() {
        ResponseDTO result =
                given()
                        .log().all()
                        .when()
                        .get(baseUri + "/user/logout")
                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

}
