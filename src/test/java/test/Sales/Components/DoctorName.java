package test.Sales.Components;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.DTO.*;
import test.Helpers.SaleFunction;


import static test.Helpers.AssertionsHelper.*;

import static io.restassured.RestAssured.given;

public class DoctorName {

    String jwt = "eyJhbGciOiJIUzUxMiIsInQiOjJ9.eyJiIjoxMjA4NzIsImMiOiI1YmJhNzg0Ni1kZWRmLTRiZDgtOWI0MS05NDFkNTRkZTJmNTYiLCJleHAiOjE3MjY3MzIzNDUsImkiOiJub25lIiwiaWF0IjoxNzI2NzAzNTQ1LCJqdGkiOiJmYWJyaXp6aW8rcWFAc2ljYXIubXgiLCJuIjoiMyIsInAiOiJBRE1JTiIsInIiOiI2OTA2MjcxZC1lYzg1LTQ4ZGYtYmRhOC01NGM1YWQ0NTk0ZGUiLCJ1IjoiZGEwYWY5ZDYtZjlmOS00ZTZlLTg0YmUtNDc2MTJmYzVkYWVlIiwidWEiOiJGQUJSSUkgUFJVRUJBUyIsIngiOjIzOTA0fQ.ds1lBKRquM9CRUEp-bRmdrD56ewWjqui3XXri7VUB4eZQhOW228mVX7yMG7XM5gSnr0A1LZtuhriMTSu5Ag0yg";

    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorNameEndsWithBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = "Dr. Fabrizzio Carbonell ";
        //Cast createSale function passing up the parameters.
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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

        assertEndsWithBlankBadRequestResponse(response, "doctorName");
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorNameStartsWithBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = " Dr. Fabrizzio Carbonell";
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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

        assertStartsWithBlankBadRequestResponse(response, "doctorName");
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorNameIsBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = "";
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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

        assertBlankBadRequestResponse(response, "doctorName");
    }

    @Test
    @Tag("ComponentsTest")
    public void DoctorNameIsNull(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = null;
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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

        assertNullBadRequestResponse(response, "doctorName");
    }


}
