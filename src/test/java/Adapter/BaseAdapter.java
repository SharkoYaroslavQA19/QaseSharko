package Adapter;


import static io.restassured.RestAssured.given;

public class BaseAdapter {
    protected final static String BASE_URL = "https://api.qase.io/v1/";
    protected final static String ACCESS_TOKEN = "5c82b8f862ec085f67294b68f6dabeeae1f748fa";

    public String get(String endpoint, int statusCode) {
        return   given()
                .header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get(BASE_URL + endpoint)
                .then().log().all()
                .statusCode(statusCode).extract().body().asString();
    }

    public String post(String endpoint, int statusCode, String requestBody) {
        return given()
                .header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .log().all()
                .post(BASE_URL + endpoint)
                .then()
                .log().all()
                .statusCode(statusCode).
                extract().body().asString();
    }
    public String delete(String endpoint, int statusCode) {
        return
                given()
                        .header("Token", ACCESS_TOKEN)
                        .header("Accept", "application/json")
                        .when()
                        .log().all()
                        .delete(BASE_URL + endpoint)
                        .then()
                        .log().all()
                        .statusCode(statusCode)
                        .extract().body().asString();
    }

    public String patch(String endpoint, int statusCode, String requestBody) {
        return given()
                .header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .log().all()
                .patch(BASE_URL + endpoint)
                .then()
                .log().all()
                .statusCode(statusCode).
                extract().body().asString();
    }

}
