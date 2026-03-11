package ShopperLogin;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import constantEndpoints.IEndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CartModuleDeleteTest {

    @Test
    public void deleteCartItem() throws Exception {
        ExcelUtility excelUtil = new ExcelUtility();
        FileUtility fileUtil = new FileUtility();

        RestAssured.baseURI = fileUtil.getDataFromProperties("BASEUri");

        int shopperId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 0));
        int productId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 1));

        Response deleteResponse = given()
                .pathParam("shopperId", shopperId)
                .pathParam("productId", productId)
                .when()
                .delete(IEndPoints.ShopperCartPut)
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Delete response: " + deleteResponse.asString());
    }
}