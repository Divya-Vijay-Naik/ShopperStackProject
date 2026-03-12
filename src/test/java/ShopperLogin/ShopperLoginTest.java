package ShopperLogin;

import org.testng.annotations.Test;

import GenericUtility.BaseAPIclass;
import GenericUtility.ExcelUtility;
import PojoUtility.LoginPojo;
import constantEndpoints.IEndPoints;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class ShopperLoginTest extends BaseAPIclass {

    @Test
    public void shopperLoginTest() throws Throwable {

        String email = excelUtility.getDataFromExcel("Sheet1",1,9);
        System.out.println(email);
        String password = excelUtility.getDataFromExcel("Sheet1",1,6);
        System.out.println(password);

        LoginPojo body = new LoginPojo(
                email,
                password,
                "SHOPPER"
        );
        Response response =
        given()
            .spec(spcReqobj)
            .relaxedHTTPSValidation()
            .contentType(ContentType.JSON)
            .body(body)

        .when()
            .post(IEndPoints.LOGIN)

        .then()
            .log().all()
            .statusCode(200)
            .extract().response();

    }
}