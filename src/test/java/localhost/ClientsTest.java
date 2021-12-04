package localhost;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

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
}
