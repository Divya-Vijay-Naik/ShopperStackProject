package ShopperLogin;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import constantEndpoints.IEndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CartModulePutTest {

    @Test
    public void updateCartItem() throws Exception {
        // Utilities
        ExcelUtility excelUtil = new ExcelUtility();
        FileUtility fileUtil = new FileUtility();

        // Base URI from properties
        RestAssured.baseURI = fileUtil.getDataFromProperties("BASEUri");

        // Read test data from Excel
        int shopperId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 0));
        int productId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 1));
        int quantity  = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 2));
        int itemId    = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 3)); // itemId stored in Excel

        // -------- PUT (Update Cart Item) --------
        String updateBody = String.format(
                "{ \"productId\": %d, \"quantity\": %d }",
                productId, quantity);

        Response putResponse = given()
                .contentType(ContentType.JSON)
                .pathParam("shopperId", shopperId)
                .pathParam("itemId", itemId)
                .body(updateBody)
                .when()
                .put(IEndPoints.ShopperCartPut)
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Update response: " + putResponse.asString());
    }
}