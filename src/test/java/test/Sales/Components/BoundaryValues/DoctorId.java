package test.Sales.Components.BoundaryValues;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.DTO.*;
import test.Helpers.SaleFunction;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static test.Helpers.AssertionsHelper.*;

public class DoctorId {

    String jwt = "eyJhbGciOiJIUzUxMiIsInQiOjJ9.eyJiIjoxMjA4NzIsImMiOiI1YmJhNzg0Ni1kZWRmLTRiZDgtOWI0MS05NDFkNTRkZTJmNTYiLCJleHAiOjE3MjY3MzIzNDUsImkiOiJub25lIiwiaWF0IjoxNzI2NzAzNTQ1LCJqdGkiOiJmYWJyaXp6aW8rcWFAc2ljYXIubXgiLCJuIjoiMyIsInAiOiJBRE1JTiIsInIiOiI2OTA2MjcxZC1lYzg1LTQ4ZGYtYmRhOC01NGM1YWQ0NTk0ZGUiLCJ1IjoiZGEwYWY5ZDYtZjlmOS00ZTZlLTg0YmUtNDc2MTJmYzVkYWVlIiwidWEiOiJGQUJSSUkgUFJVRUJBUyIsIngiOjIzOTA0fQ.ds1lBKRquM9CRUEp-bRmdrD56ewWjqui3XXri7VUB4eZQhOW228mVX7yMG7XM5gSnr0A1LZtuhriMTSu5Ag0yg";

    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    @Tag("BoundaryValues")
    public void MinimumLengthValue(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "1";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //.log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertCreateResponse(response);
    }

    @Test
    @Tag("BoundaryValues")
    public void MinimumLengthValueMinusOne(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //.log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertBlankBadRequestResponse(response, "DoctorID"); //The second parameter have to be the test case field (DoctorId, DoctorName, folio, etc).
    }

    @Test
    @Tag("BoundaryValues")
    public void MinimumLengthValuePLusOne(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "12";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //.log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();
        assertCreateResponse(response);
    }

    @Test
    @Tag("BoundaryValues")
    public void MaximumLengthValue(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "123456789012345678901234567890123456789012345";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //.log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertCreateResponse(response);
    }

    @Test
    @Tag("BoundaryValues")
    public void MaximumLengthValueMinusOne(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "12345678901234567890123456789012345678901234";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //.log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertCreateResponse(response);
    }

    @Test
    @Tag("BoundaryValues")
    public void MaximumLengthValuePlusOne(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorId = "1234567890123456789012345678901234567890123456";
        SalesDTO sales = SaleFunction.createSale(doctorId, "Dr. Fabrizzio Carbonell","123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //.log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertMaximumLengthBadRequestResponse(response, "doctorId", "45");
    }
}
