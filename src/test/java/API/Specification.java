package API;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public static RequestSpecification requestSpec(String url){
        // здесь мы напишем по какой ссылке нам необходимо будет обращаться и какой тип данных нам стоит ожидать
        return new RequestSpecBuilder()
                .setBaseUri(url)    //это то, какая ссылка у нас будет базовая
                .setContentType(ContentType.JSON)
                .build();
                // далее нам нужно указать какой нам ответ стоит ожидать

    }

    public static ResponseSpecification responseSpecOK200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
