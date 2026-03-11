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
	
	
	public static String email;

    @Test
    public void shopperLoginTest() throws Throwable
    {
    	
    	LoginPojo body = new LoginPojo(
    	        "test1773204716877@gmail.com",
    	        "Password@123",
    	        "SHOPPER"
    	);
   

    	Response res = given()
    			.relaxedHTTPSValidation()
    			.contentType(ContentType.JSON)
    			.body(body)

    			.when()
    			.post(IEndPoints.LOGIN);

    			res.then().log().all();

    			int userId = res.jsonPath().getInt("data.userId");
    			String jwtToken = res.jsonPath().getString("data.jwtToken");

    			ExcelUtility eUtil = new ExcelUtility();

    			eUtil.writeDataIntoExcel("Sheet1",1,0,String.valueOf(userId));
    			eUtil.writeDataIntoExcel("Sheet1",1,1,jwtToken);
    }
}