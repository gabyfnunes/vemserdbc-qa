package homework.gaby.rest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class HomeworkAulaUm {
    private String baseUrl = "https://reqres.in/api";

    @Test
    public void testeDeveConsultarListaUsers() {

        given()
                .log().all()
                .queryParam("page", "2")
                .when()
                .get(baseUrl + "/users")
                .then()
                .log().all()
                .statusCode(200)
                .body("total_pages", equalTo(2))
                .body("data", hasSize(6))
                .body("data.email", hasItem("byron.fields@reqres.in"))
                .body("data[2].last_name", is("Funke"))
                .body("total", notNullValue())
        ;
    }

    @Test
    public void testeDeveConsultarSomenteUmUser() {

        given()
                .log().all()

                .when()
                .get(baseUrl + "/users/4")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", equalTo(4))
                .body("data.last_name", equalTo("Holt"))
                .body("data.first_name", containsString("Eve"))
        ;
    }

    @Test
    public void testeDeveConsultarUmUserInexistente() {

        given()
                .log().all()
                .when()
                .get(baseUrl + "/users/72")
                .then()
                .log().all()
                .statusCode(404)
                .body("data", nullValue())
        ;
    }

    @Test
    public void testeDeveCriarUser() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Roberval\", \"Idade\" : \"42\", \"Cidade\" : \"Rio de Janeiro\"}")
                .when()
                .post(baseUrl + "/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", notNullValue())
                .body(containsString("id"))
        ;
    }

    @Test
    public void testeDeveAtualizarUserComPut() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Roberval\", \"Idade\" : \"45\", \"Cidade\" : \"Rio de Janeiro\"}")
        .when()
                .put(baseUrl + "/users/310")
                .then()
                .log().all()
                .statusCode(200);
        ;
    }
    @Test
    public void testeDeveAtualizarUserComPatch() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Josiclei\", \"Idade\" : \"32\", \"Estado\" : \"Minas Gerais\"}")
                .when()
                .patch(baseUrl + "/users/310")
                .then()
                .log().all()
                .statusCode(200);
        ;
    }

    @Test
    public void testeDeveDeletarUser() {

        given()
                .log().all()
                .contentType(ContentType.JSON)

                .when()
                .delete(baseUrl + "/users/310")
                .then()
                .log().all()
                .statusCode(204);
        ;
    }
    @Test
    public void testeRegistrarUser() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}")
                .when()
                .post(baseUrl + "/register")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", notNullValue())
                .body(containsString("id"))
        ;
    }
    @Test
    public void testeDeveDarErroAoRegistrarUser() {

        given()
                .log().all()
                .body("{\"email\" : \"sydney@fif\"}")
                .when()
                .post(baseUrl + "/register")
                .then()
                .log().all()
                .statusCode(400)
        ;
    }
    @Test
    public void testeLogin() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}")
                .when()
                .post(baseUrl + "/login")
                .then()
                .log().all()
                .statusCode(200)
        ;
    }
    @Test
    public void testeDeveDarErroAoLogar() {

        given()
                .log().all()
                .body("{\"email\" : \"peter@klaven\"}")
                .when()
                .post(baseUrl + "/login")
                .then()
                .log().all()
                .statusCode(400)
        ;
    }



}

