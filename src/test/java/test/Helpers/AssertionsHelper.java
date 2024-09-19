package test.Helpers;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class AssertionsHelper {

    public static void assertCreateResponse(ValidatableResponse response){
        response
                .statusCode(201)
                .body("status", equalTo("ACTIVE"));
    }

    public static void assertCreateFailedResponse(ValidatableResponse response){
        response
                .statusCode(201)
                .body("status", equalTo("FAILED"));
    }

    public static void assertNotFoundRequestResponse(ValidatableResponse response, String doctorId){
        response
                .statusCode(404)
                .body("code", equalTo(0))
                .body("message", equalTo("Doctor with id " + doctorId + " not found"));
    }

    public static void assertInvalidValueBadRequestResponse(ValidatableResponse response, String doctorId){
        response
                .statusCode(400)
                .body("code", equalTo(0))
                .body("message", equalTo("prescription.doctorId with value " + doctorId + " is not valid"));
    }

    public static void assertNullBadRequestResponse(ValidatableResponse response, String field){
        response
                .statusCode(400)
                .body("code", equalTo(2))
                .body("message", equalTo(field + " must not be null"));
    }

    public static void assertBlankBadRequestResponse(ValidatableResponse response, String field){
        response
                .statusCode(400)
                .body("code", equalTo(1))
                .body("message", equalTo(field + " is blank"));
    }

    public static void assertStartsWithBlankBadRequestResponse(ValidatableResponse response, String field){
        response
                .statusCode(400)
                .body("code", equalTo(1))
                .body("message", equalTo(field + " starts with blank"));
    }

    public static void assertEndsWithBlankBadRequestResponse(ValidatableResponse response, String field){
        response
                .statusCode(400)
                .body("code", equalTo(1))
                .body("message", equalTo(field + " end with blank"));
    }

    public static void assertMinimumLengthBadRequestResponse(ValidatableResponse response, String field, String minimumLength){
        response
                .statusCode(400)
                .body("code", equalTo(1))
                .body("message", equalTo(field + " length must not be shorter than " + minimumLength));
    }
    public static void assertMaximumLengthBadRequestResponse(ValidatableResponse response, String field, String maximumLength){
        response
                .statusCode(400)
                .body("code", equalTo(1))
                .body("message", equalTo(field + " length must not be larger than " + maximumLength));
    }
}
