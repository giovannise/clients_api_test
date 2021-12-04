package localhost;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ClientsTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/clients";
    }

    @Test
    void testListaClientes_TodosClientesSaoListados() {
        RestAssured.given()
                .log().all()
                .when()
                .get()//pode deixar vazio porque já está setado no BeforeAll
                .then()
                .log().all()
                .statusCode(200);
    }

    /*
    @Test
    void testListaUnicoCliente_ClienteEListadoComTodasAsInformacoes() {
        RestAssured.given()
                .log().all()
                .when()
                .get("http://localhost:8080/clients/1")
                .then()
                .log().all()
                .statusCode(200);
    }
     */

    @Test
    void testListaUnicoCliente_ClienteEListadoComTodasAsInformacoesComBody() {

        int id = 1;

        RestAssured.given()
                .log().all()
                .when()
                .get("/" + id) //pode botar só o que vem depois de clients na URL porque ela já está setado no BeforeAll
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is(id));
    }

    @Test
    void testInlcuiCliente_ClienteEIncluidoComSucesso() {

        String email = "senhorateste@teste.com";
        String name = "Teste";

        RestAssured.given()
                .body("{\n" +
                        "        \"email\": \""+ email +"\", \n" +
                        "        \"name\": \""+ name +"\" \n" +
                        "    }")
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .post() //pode botar só o que vem depois de clients na URL porque ela já está setado no BeforeAll
                .then()
                .log().all()
                .statusCode(201);
    }
}
