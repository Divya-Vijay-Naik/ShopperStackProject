package ShopperLogin;

import GenericUtility.BaseAPIclass;
import constantEndpoints.IEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CartModuleTest extends BaseAPIclass {

    @Test(priority = 1)
    public void addCartItem() throws Exception {
        int shopperId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 0));
        int productId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 1));
        int quantity  = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 2));

        String requestBody = String.format("{ \"productId\": %d, \"quantity\": %d }", productId, quantity);

        Response postResponse = given()
                .spec(spcReqobj)
                .contentType(ContentType.JSON)
                .pathParam("shopperId", shopperId)
                .body(requestBody)
                .when()
                .post(IEndPoints.ShopperCart)
                .then()
                .spec(spcRespobj)
                .extract().response();

        System.out.println("Add item response: " + postResponse.asString());
    }

    @Test(priority = 2)
    public void getCartItems() throws Exception {
        int shopperId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 0));

        Response getResponse = given()
                .spec(spcReqobj)
                .pathParam("shopperId", shopperId)
                .when()
                .get(IEndPoints.ShopperCart)
                .then()
                .spec(spcRespobj)
                .extract().response();

        System.out.println("Cart contents: " + getResponse.asString());
    }

    @Test(priority = 3)
    public void updateCartItem() throws Exception {
        int shopperId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 0));
        int productId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 1));
        int quantity  = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 2));
        int itemId    = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 3));

        String updateBody = String.format("{ \"productId\": %d, \"quantity\": %d }", productId, quantity);

        Response putResponse = given()
                .spec(spcReqobj)
                .pathParam("shopperId", shopperId)
                .pathParam("itemId", itemId)
                .body(updateBody)
                .when()
                .put(IEndPoints.ShopperCartPut)
                .then()
                .spec(spcRespobj)
                .extract().response();

        System.out.println("Update response: " + putResponse.asString());
    }

    @Test(priority = 4)
    public void deleteCartItem() throws Exception {
        int shopperId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 0));
        int productId = Integer.parseInt(excelUtility.getDataFromExcel("CartData", 1, 1));

        Response deleteResponse = given()
                .spec(spcReqobj)
                .pathParam("shopperId", shopperId)
                .pathParam("productId", productId)
                .when()
                .delete(IEndPoints.ShopperCartPut)
                .then()
                .spec(spcRespobj)
                .extract().response();

        System.out.println("Delete response: " + deleteResponse.asString());
    }
}