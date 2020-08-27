import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DesafioPrincipal {

    @Test
    public void consultaCEPValidoTest() {
        given().
                when().
                get("https://viacep.com.br/ws/91060900/json/").
                then().
                statusCode(200).
                assertThat().
                body("cep", equalTo("91060-900"));
    }

    @Test
    public void consultaCEPInvalidoTest() {
        given().
                when().
                get("https://viacep.com.br/ws/12345678/json/").
                then().
                statusCode(200).
                assertThat().
                body("erro", equalTo(true));
    }

    @Test
    public void consultaCEPFormatoInvalidoTest() {
        given().
                when().
                get("https://viacep.com.br/ws/910609/json/").
                then().
                assertThat().
                statusCode(400);
    }
}
