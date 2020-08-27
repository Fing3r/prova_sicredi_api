import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class DesafioExtra {

    @Test
    public void consultaCEPBarrosoTest() {
        given().
                when().
                get("https://viacep.com.br/ws/RS/Gravatai/Barroso/json/").
                then().
                statusCode(200).
                assertThat().
                body("size()", is(2)).
                and().
                assertThat().
                body("[0].cep",equalTo("94085-170"));
    }

}