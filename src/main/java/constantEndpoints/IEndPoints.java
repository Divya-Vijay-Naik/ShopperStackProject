package constantEndpoints;

public interface IEndPoints {



	public String AddProject="/addProject";
	public String ShopperCart ="/shoppers/{shopperId}/carts";
	public String ShopperCartPut="/shoppers/{shopperId}/carts/{itemId}";



	public String GetAddress="/shoppers/{shopperId}/address";
	public String GetParticularAddress="/shoppers/{shopperId}/address/{addressId}";

	  String BASE_URI="https://www.shoppersstack.com/shopping";


	    String REGISTER_SHOPPER="/shoppers";

	    String LOGIN="/users/login";

	    String GET_SHOPPER="/shoppers/{shopperId}";

	    String UPDATE_SHOPPER="/shoppers/{shopperId}";
	    
	    String DELETE_SHOPPER = "/shoppers/{shopperId}";


}
