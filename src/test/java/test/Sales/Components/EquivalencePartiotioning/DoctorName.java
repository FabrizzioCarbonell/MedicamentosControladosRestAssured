package test.Sales.Components.EquivalencePartiotioning;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.DTO.*;
import test.Helpers.SaleFunction;

import static io.restassured.RestAssured.given;
import static test.Helpers.AssertionsHelper.*;

public class DoctorName {

    String jwt = "eyJhbGciOiJIUzUxMiIsInQiOjJ9.eyJiIjoxMjA4NzIsImMiOiI1YmJhNzg0Ni1kZWRmLTRiZDgtOWI0MS05NDFkNTRkZTJmNTYiLCJleHAiOjE3MjY3ODgwNjksImkiOiJub25lIiwiaWF0IjoxNzI2NzU5MjY5LCJqdGkiOiJmYWJyaXp6aW8rcWFAc2ljYXIubXgiLCJuIjoiMyIsInAiOiJBRE1JTiIsInIiOiI2OTA2MjcxZC1lYzg1LTQ4ZGYtYmRhOC01NGM1YWQ0NTk0ZGUiLCJ1IjoiZGEwYWY5ZDYtZjlmOS00ZTZlLTg0YmUtNDc2MTJmYzVkYWVlIiwidWEiOiJGQUJSSUkgUFJVRUJBUyIsIngiOjIzOTA0fQ.d1dL_t1C_GCk5M_o2dfIzobyKeUCWYC3KEaJ6LG8qA6KottUMJW1TsaXm8ck75X-i2VT184Nl8kG3_ri-smd9A";


    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    @Tag("EquivalencePartitioning")
    public void ExistingDoctorName(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = "Dr. Fabrizzio Carbonell";
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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
    @Tag("EquivalencePartitioning")
    public void NoExistingDoctorName(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = "Dr. Carbonell";
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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
    @Tag("EquivalencePartitioning")
    public void DoctorNameWithABC(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = "DR. FABRIZZIO CARBONELL";
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


        //Post request
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                //log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all();

        assertCreateResponse(response);
    }

    @Test
    @Tag("EquivalencePartitioning")
    public void DoctorNameWithSpecialCharacters(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String doctorName = "#Dr F@br1zZ1o C@rb@nel1";
        SalesDTO sales = SaleFunction.createSale("123456879", doctorName,"123456", "Se vende desde inteliJ","123", false);


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
}
