import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.sql.DriverManager.println;

public class ReqRestServices {
    String date = "22/01/1989";
    @Test
    public void helloTestingWorld(){
        System.out.printf("Mi fecha es: " + date);
    }
    @Test
    public void LoginTest(){
        String response= RestAssured
        .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post( "https://regres.in/api/login")
                .then().extract().asString();

        System.out.println("la respuesta es:\n"+response);

    }

}

