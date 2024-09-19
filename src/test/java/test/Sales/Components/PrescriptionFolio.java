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

import static test.Helpers.AssertionsHelper.*;

import static io.restassured.RestAssured.given;

public class PrescriptionFolio {

    String jwt = AuthHelper.getCompanyJwtToken();

    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    @Tag("ComponentsTest")
    public void PrescriptionFolioEndsWithBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String prescriptionFolio = "123456 ";
        //Cast createSale function passing up the parameters.
        SalesDTO sales = SaleFunction.createSale("123456879", "Dr. Fabrizzio Carbonell", prescriptionFolio, "Se vende desde inteliJ","123", false);


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

        assertEndsWithBlankBadRequestResponse(response, "prescriptionFolio");
    }

    @Test
    @Tag("ComponentsTest")
    public void PrescriptionFolioStartsWithBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String prescriptionFolio = " 123456";
        SalesDTO sales = SaleFunction.createSale("123456879", "Dr. Fabrizzio Carbonell",  prescriptionFolio, "Se vende desde inteliJ","123", false);


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

        assertStartsWithBlankBadRequestResponse(response, "prescriptionFolio");
    }

    @Test
    @Tag("ComponentsTest")
    public void PrescriptionFolioIsBlank(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String prescriptionFolio = "";
        SalesDTO sales = SaleFunction.createSale("123456879", "Dr. Fabrizzio Carbonell", prescriptionFolio, "Se vende desde inteliJ","123", false);


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

        assertBlankBadRequestResponse(response, "prescriptionFolio");
    }

    @Test
    @Tag("ComponentsTest")
    public void PrescriptionFolioIsNull(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        String prescriptionFolio = null;
        SalesDTO sales = SaleFunction.createSale("123456879", "Dr. Fabrizzio Carbonell",prescriptionFolio, "Se vende desde inteliJ","123", false);


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

        assertNullBadRequestResponse(response, "prescriptionFolio");
    }


}
