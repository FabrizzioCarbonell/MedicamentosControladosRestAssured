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

public class Retained {

    String jwt = "eyJhbGciOiJIUzUxMiIsInQiOjJ9.eyJiIjoxMjA4NzIsImMiOiI1YmJhNzg0Ni1kZWRmLTRiZDgtOWI0MS05NDFkNTRkZTJmNTYiLCJleHAiOjE3MjY3MzIzNDUsImkiOiJub25lIiwiaWF0IjoxNzI2NzAzNTQ1LCJqdGkiOiJmYWJyaXp6aW8rcWFAc2ljYXIubXgiLCJuIjoiMyIsInAiOiJBRE1JTiIsInIiOiI2OTA2MjcxZC1lYzg1LTQ4ZGYtYmRhOC01NGM1YWQ0NTk0ZGUiLCJ1IjoiZGEwYWY5ZDYtZjlmOS00ZTZlLTg0YmUtNDc2MTJmYzVkYWVlIiwidWEiOiJGQUJSSUkgUFJVRUJBUyIsIngiOjIzOTA0fQ.ds1lBKRquM9CRUEp-bRmdrD56ewWjqui3XXri7VUB4eZQhOW228mVX7yMG7XM5gSnr0A1LZtuhriMTSu5Ag0yg";

    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    @Tag("ComponentsTest")
    public void RetainedIsNull(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        Boolean retained = null;
        //Cast createSale function passing up the parameters.
        SalesDTO sales = SaleFunction.createSale("123456879", "Dr. Fabrizzio Carbonell", "123456", "Se vende desde inteliJ" , "123", retained);


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

        assertCreateResponse(response); //Se crea de todos modos por que por defecto siempre se manda en FALSE
    }
}
