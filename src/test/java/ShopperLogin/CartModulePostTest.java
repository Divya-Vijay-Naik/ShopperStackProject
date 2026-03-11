package ShopperLogin;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import constantEndpoints.IEndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CartModulePostTest {

    @Test
    public void addCartItem() throws Exception {
        ExcelUtility excelUtil = new ExcelUtility();
        FileUtility fileUtil = new FileUtility();

        RestAssured.baseURI = fileUtil.getDataFromProperties("BASEUri");

        int shopperId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 0));
        int productId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 1));
        int quantity  = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 2));

        String requestBody = String.format(
                "{ \"productId\": %d, \"quantity\": %d }",
                productId, quantity);

        Response postResponse = given()
                .contentType(ContentType.JSON)
                .pathParam("shopperId", shopperId)
                .body(requestBody)
                .when()
                .post(IEndPoints.ShopperCart)
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println("Add item response: " + postResponse.asString());
    }
}