package constantEndpoints;

public interface IEndPoints {


	public String GetAddress="/shoppers/{shopperId}/address";
	public String GetParticularAddress="/shoppers/{shopperId}/address/{addressId}";
	  String BASE_URI="https://www.shoppersstack.com/shopping";

//>>>>>>> branch 'SecondBranch' of https://github.com/Divya-Vijay-Naik/ShopperStackProject.git

	    String REGISTER_SHOPPER="/shoppers";

	    String LOGIN="/users/login";

	    String GET_SHOPPER="/shoppers/{shopperId}";

	    String UPDATE_SHOPPER="/shoppers/{shopperId}";
	    
	    String DELETE_SHOPPER = "/shoppers/{shopperId}";

// branch 'SecondBranch' of https://github.com/Divya-Vijay-Naik/ShopperStackProject.git
}
