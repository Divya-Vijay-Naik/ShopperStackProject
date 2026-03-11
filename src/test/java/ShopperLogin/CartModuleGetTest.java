package ShopperLogin;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import constantEndpoints.IEndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CartModuleGetTest {

    @Test
    public void getCartItems() throws Exception {
        ExcelUtility excelUtil = new ExcelUtility();
        FileUtility fileUtil = new FileUtility();

        RestAssured.baseURI = fileUtil.getDataFromProperties("BASEUri");

        int shopperId = Integer.parseInt(excelUtil.getDataFromExcel("CartData", 1, 0));

        Response getResponse = given()
                .pathParam("shopperId", shopperId)
                .when()
                .get(IEndPoints.ShopperCart)
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Cart contents: " + getResponse.asString());
    }
}