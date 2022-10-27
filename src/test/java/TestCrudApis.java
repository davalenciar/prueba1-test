import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class TestCrudApis {
    /**
     * prueba*/
    @Test
    public void Post_test() {
        String response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON).
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}").post("https://reqres.in/api/register")
                .then()
                .log()
                .all()
                .extract()
                .asString();
        System.out.println("La respuesta es:\n" + response);

    }

    @Test
        public void GetListUnknown() {
            RestAssured.when().get("https://reqres.in/api/unknown").
                    then().log().all();

        }

    @Test
    public void delete_test() {
        RestAssured.when().delete("https://reqres.in/api/users/2").
                then().log().all();

    }
    @Test
    public void PutUpdateUnknown(){
        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"Wilber Perez\",\n" +
                        "    \"job\": \"QA Automation JR\"\n" +
                        "}")
                .put("https://reqres.in/api/users/7")
                .then()
                .log().all()
                .extract().asString();
    }
}


