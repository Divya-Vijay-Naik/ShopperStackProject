package ShopperLogin;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIclass;
import PojoUtility.PojoAddressClass;
import constantEndpoints.IEndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class ShopperStackAddress extends BaseAPIclass {
		PojoAddressClass pojo;
		    @Test
		    public void testGetShopperAddresses_JSON() {
		        //RestAssured.baseURI = "http://your-api-base-url.com"; // replace with actual base URL

		    	
		        int shopperId = 354095; // replace with actual shopperId
		        pojo=new PojoAddressClass(
		        		 0,
		        	        "Building A",
		        	        "Bengaluru",
		        	        "India",
		        	        "Near Park",
		        	        "Deepika",
		        	        "9876543210",
		        	        "560001",
		        	        "Karnataka",
		        	        "MG Road",
		        	        "Home"
		        		);
		        RestAssured.useRelaxedHTTPSValidation();

		        Response resp = given()
		                .spec(spcReqobj)
		                .pathParam("shopperId", shopperId)
		                .body(pojo)
		                .when()
		                .post(IEndPoints.GetAddress);

		        resp.then()
		                .assertThat().statusCode(201) // POST should return 201 Created
		                .assertThat().time(Matchers.lessThan(3000L))
		                .spec(spcRespobj)
		                .log().all();

		        String addressId = resp.jsonPath().getString("data.addressId");
		        System.out.println("Created Address ID: " + addressId);
		        		
		    }

		    @Test
		    public void testGetShopperAddresses_XML() {
		        //RestAssured.baseURI = "http://your-api-base-url.com"; // replace with actual base URL

		        int shopperId = 123; // replace with actual shopperId

//		        Response response = given()
//		            .pathParam("shopperId", shopperId)
//		            .accept(ContentType.XML)
//		        .when()
//		            .get("/shoppers/{shopperId}/address");
//
//		        response.then()
//		            .statusCode(200)
//		            .contentType(ContentType.XML);
//
//		        // Example: extract values from XML
//		        String city = response.xmlPath().getString("ResponseStructure.data.city");
//		        System.out.println("City: " + city);
		        Response resp = given()
		                .spec(spcReqobj)
		                .pathParam("shopperId", shopperId)
		                .body(pojo)
		                .when()
		                .post(IEndPoints.GetAddress);

		        resp.then()
		                .assertThat().statusCode(200)
		        	.spec(spcRespobj)
		        	.log().all();
		    }
		
	}



