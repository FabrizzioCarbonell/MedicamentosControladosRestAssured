package test.Sales.Components;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.DTO.*;
import test.Helpers.AuthHelper;
import test.Helpers.SaleFunction;

import static io.restassured.RestAssured.given;
import static test.Helpers.AssertionsHelper.*;

public class DoctorId {

    String jwt = AuthHelper.getCompanyJwtToken();


    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorIdEndsWithBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "123456879 ";
        //Cast createSale function passing up the parameters.
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();
        assertEndsWithBlankBadRequestResponse(response, "doctorId");
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorIdStartsWithBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = " 123456879";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertStartsWithBlankBadRequestResponse(response, "doctorId");
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorIdIsBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertBlankBadRequestResponse(response, "doctorId");
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorIdIsNull(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = null;
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertNullBadRequestResponse(response, "doctorId");
    }
}
