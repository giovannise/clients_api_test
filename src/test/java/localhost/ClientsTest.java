package localhost;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ClientsTest {

    @Test
    void testListaClientes_TodosClientesSaoListados() {
        RestAssured.given()
                .log().all()
                .when()
                .get("http://localhost:8080/clients")
                .then()
                .log().all()
                .statusCode(200);
    }

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

    @Test
    void testUnicoClientes_ClienteEListadoComTodasAsInformacoesComBody() {
        RestAssured.given()
                .log().all()
                .when()
                .get("http://localhost:8080/clients/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is(1));
    }
}
