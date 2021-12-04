package localhost;

import io.restassured.RestAssured;
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
    void testUnicoClientes_ClienteEListadoComTodasAsInformacoes() {
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
    void testUnicoClientes_ClienteEListadoComTodasAsInformacoesComBody() {

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
}
