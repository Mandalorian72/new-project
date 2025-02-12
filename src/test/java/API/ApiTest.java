package API;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private final static String URL = "https://restful-booker.herokuapp.com/";

    @Test
    public void getBookingTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        List<UserData> users = given() //given() - метод для работы с запросами
                .when()
                .get("booking/1225") // по какому адресу идти
                .then().log().all() // вывод всего в консоль
                .extract().body().jsonPath().getList("firstname", UserData.class);  //извлечение данных из jsonа


    }

    @Test
    public void successAuth(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        String token = "abc123";

        Authorization auth = new Authorization("admin", "password123");
        SuccessAuthorization successAuthorization = given()
                .body(auth)
                .when()
                .post("auth")
                .then().log().all()
                .extract().as(SuccessAuthorization.class);

        Assertions.assertEquals(token, successAuthorization.getToken());

    }
}
