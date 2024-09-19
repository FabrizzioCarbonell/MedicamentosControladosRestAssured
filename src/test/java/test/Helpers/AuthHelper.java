package test.Helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AuthHelper {

    private static String companyJwtToken = null;
    private static String enterpriseJwtToken = null;
    private static final String COMPANY_TOKEN_FILE = "company_jwt_token.txt";
    private static final String ENTERPRISE_TOKEN_FILE = "enterprise_jwt_token.txt";

    // Método para obtener el token de la empresa
    public static String getEnterpriseJwtToken() {
        if (enterpriseJwtToken == null || isTokenExpired(enterpriseJwtToken)) {
            enterpriseJwtToken = readTokenFromFile(ENTERPRISE_TOKEN_FILE);
            if (enterpriseJwtToken == null) {
                enterpriseJwtToken = loginToEnterprise();
                writeTokenToFile(ENTERPRISE_TOKEN_FILE, enterpriseJwtToken);
            }
        }
        return enterpriseJwtToken;
    }

    // Método para obtener el token de la compañía
    public static String getCompanyJwtToken() {
        if (companyJwtToken == null || isTokenExpired(companyJwtToken)) {
            companyJwtToken = readTokenFromFile(COMPANY_TOKEN_FILE);
            if (companyJwtToken == null) {
                companyJwtToken = loginToCompany();
                writeTokenToFile(COMPANY_TOKEN_FILE, companyJwtToken);
            }
        }
        return companyJwtToken;
    }

    // Método para hacer el login a la empresa
    private static String loginToEnterprise() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"deviceType\":\"Web\",\"deviceId\":\"5cb3354150c55b42aa7ea9369e5ce97ddd28933870119bd1d894b104208882f333cfdafc2a06644aeccdb45b9e92c29b614a4b38ef56e8bdeb73fcac59ce1554\",\"deviceAlias\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:131.0) Gecko/20100101 Firefox/131.0\",\"email\":\"fabrizzio+qa@sicar.mx\",\"password\":\"df5cce66f99067ab8547042db353d956b1d932063f4ce349b8bf3a90c27959a8ddd086ff052fb14a4aa259eac5873a23c0b45fe9274b33a785d1f2154960c795\"}")
                .post("https://vgobnw4kijvpythw3nli6ibosa0dzjql.lambda-url.us-east-1.on.aws/login/v1/account");

        String jwt = response.jsonPath().getString("jwt");
        return jwt;
    }

    // Método para hacer el login a la compañía
    private static String loginToCompany() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"branchId\":120872,\"deviceId\":\"5cb3354150c55b42aa7ea9369e5ce97ddd28933870119bd1d894b104208882f333cfdafc2a06644aeccdb45b9e92c29b614a4b38ef56e8bdeb73fcac59ce1554\",\"deviceAlias\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:131.0) Gecko/20100101 Firefox/131.0\",\"fcmId\":null,\"deviceType\":\"Web\",\"jwt\": \"" + getEnterpriseJwtToken() + "\"}")
                .post("https://vgobnw4kijvpythw3nli6ibosa0dzjql.lambda-url.us-east-1.on.aws/login/v1/login");

        String jwt = response.getHeader("cauth");
        return jwt;
    }

    // Método para leer el token de un archivo
    private static String readTokenFromFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            return null; // Si no existe el archivo o hay un error, retorna null
        }
    }

    // Método para escribir el token en un archivo
    private static void writeTokenToFile(String fileName, String token) {
        try {
            Files.write(Paths.get(fileName), token.getBytes());
        } catch (IOException e) {
            System.out.println("Error writing token to file: " + e.getMessage());
        }
    }

    // Método opcional para verificar si el JWT ha caducado
    private static boolean isTokenExpired(String token) {
        // Lógica para verificar si el token ha caducado
        return false; // Cambia esto según tu lógica de verificación
    }
}
