package API;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


import static io.restassured.RestAssured.given;

@Execution(ExecutionMode.SAME_THREAD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ApiTest {
    private final static String URL = "https://restful-booker.herokuapp.com/";
    private static String authToken;
    private static String userName = "admin";
    private static String password = "password123";
    private static String firstname = "Alexey";
    private static String lastname = "Astapov";
    private static Integer totalPrice = 777;
    private static Boolean depositPaid = true;
    private static String checkin = "2018-01-01";
    private static String checkout = "2018-01-31";
    private static String additionalneeds = "Breakfast";
    private static Integer bookingId;
    private static Integer newPrice = 100;


    @Test
    @Order(1)
    public void successAuthTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());

        Authorization auth = new Authorization(userName, password);
        String token = given()
                .body(auth)
                .when()
                .post("auth")
                .then().log().all()
                .extract().jsonPath().getString("token"); //а как получить не все параметры, а только 1?
        authToken = token; //для повторного использования

        Assertions.assertNotNull(authToken);
    }

    @Test
    @Order(2)
    public void createBookingTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());

        BookingRequest requestParams = new BookingRequest(firstname, lastname, totalPrice, depositPaid, new BookingRequest.Bookingdates(checkin, checkout), additionalneeds);
        BookingResponse bookingResponse = given()
                .body(requestParams)
                .when()
                .post("booking")
                .then().log().body()
                .extract().as(BookingResponse.class);
        bookingId = bookingResponse.getBookingid();

        Assertions.assertNotNull(bookingResponse);
    }

    @Test
    @Order(3)
    public void getBookingTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        BookingRequest booking = given() //given() - метод для работы с запросами
                .when()
                .get("booking/" + bookingId) // по какому адресу идти
                .then().log().all() // вывод всего в консоль
                .extract().as(BookingRequest.class); //извлечение данных из jsonа
        // по какому принципу происходит извлечение данных в переменные из jsona
        Assertions.assertNotNull(booking);
    }

    @Test
    @Order(4)
    public void priceUpdateTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        BookingRequest requestParams = new BookingRequest(firstname, lastname, newPrice, depositPaid, new BookingRequest.Bookingdates(checkin, checkout), additionalneeds);
        BookingRequest booking = given()
//                .header("Authorization", authToken)
                .cookie("token", authToken)
                .body(requestParams)
                .when()
                .put("booking/" + bookingId)
                .then().log().body()
                .extract().as(BookingRequest.class);

        Assertions.assertEquals(newPrice, booking.getTotalprice());
    }

    @Test
    @Order(5)
    public void deleteBookingTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(201));
        given()
                .cookie("token", authToken)
                .when()
                .delete("booking/" + bookingId)
                .then().log().all();
    }

    @Test
    @Order(6)
    public void getDeletedBookingTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(404));
        given()
                .when()
                .get("booking/" + bookingId)
                .then().log().all();
        // по какому принципу происходит извлечение данных в переменные из jsona
    }
}
