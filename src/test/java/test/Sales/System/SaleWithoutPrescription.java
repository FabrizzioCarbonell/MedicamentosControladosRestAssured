package test.Sales.System;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.DTO.*;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleWithoutPrescription {

    String jwt = "eyJhbGciOiJIUzUxMiIsInQiOjJ9.eyJiIjoxMjA4NzIsImMiOiI1YmJhNzg0Ni1kZWRmLTRiZDgtOWI0MS05NDFkNTRkZTJmNTYiLCJleHAiOjE3MjY3MDIxNzcsImkiOiJub25lIiwiaWF0IjoxNzI2NjczMzc3LCJqdGkiOiJmYWJyaXp6aW8rcWFAc2ljYXIubXgiLCJuIjoiMyIsInAiOiJBRE1JTiIsInIiOiI2OTA2MjcxZC1lYzg1LTQ4ZGYtYmRhOC01NGM1YWQ0NTk0ZGUiLCJ1IjoiZGEwYWY5ZDYtZjlmOS00ZTZlLTg0YmUtNDc2MTJmYzVkYWVlIiwidWEiOiJGQUJSSUkgUFJVRUJBUyIsIngiOjIzOTA0fQ.guEqfY5F7Ics1qx_ft0UHFf4tClJpUC7aRUn6alz7LW7_b-TCzNpY9cPRVTQbjowiGDAqie6Ykn7WcMnU5Ni-g";
    public static String generateRandomUUID() {return UUID.randomUUID().toString();}

    //Consumir DTO mediante Builder
    ProductDTO.Lot lot = new ProductDTO.Lot.Builder().lotNumber("FC").quantity("1").build();

    AgentDTO agent = new AgentDTO.Builder("85e406dc-ddd3-422a-992d-9d69ed552f97")
            .name("Cliente medicamentos controlados")
            .withholdTaxes(false)
            .key("medControlled")
            .priceNumber(1)
            .build();

    ProductDTO products = new ProductDTO.Builder("2jQtfKfr4w63frsYvjCeqtdOGsM")
            .type(8)
            .sku("alpra02")
            .additionalInfo("0.5 mg")
            .description("Alprazolam 0.5 mg")
            .unit("CAJA")
            .quantity("1")
            .priceBaseTax("250.00")
            .priceTax("250.00")
            .amountTax("250.00")
            .purchasePriceTax(140)
            .taxesIds(List.of("e43621dc-748a-46e1-8a92-1e7ef7cb6f09"))
            .lots(List.of(lot))
            .build();
    PaymentsDTO payments = new PaymentsDTO.Builder()
            .paymentId("CASH")
            .amount("250")
            .build();

    @BeforeAll
    public static void setup() {
        // Registrar parser para tratar text/plain como JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    public void SaleWithoutPrescription(){
        RestAssured.baseURI = "https://dev.sicarx.com";
        String endpoint = "/sale/v1/sale";

        SalesDTO sales = new SalesDTO.Builder(generateRandomUUID(), "SALE")
                .decimals(2)
                .isoCurrency("MXN")
                .opMode("MX")
                .total("250")
                .serie("")
                .timeZone("America/Mexico_City")
                .cashRegisterUuid("b3934e0e-89b6-46cc-9262-7c1e2d67788a")
                .agent(agent)
                .products(List.of(products))
                .payments(List.of(payments))
                .build();

        //Post request
        given()
                .contentType("application/json")
                .header("Authorization", jwt)
                .body(sales)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(400)
                .body("code", equalTo(2))
                .body("message", equalTo("prescription must not be null"));
    }
}
