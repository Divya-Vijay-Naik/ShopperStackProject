package constantEndpoints;

public interface IEndPoints {

	public String AddProject="/addProject";
	public String ShopperCart ="/shoppers/{shopperId}/carts";
	public String ShopperCartPut="/shoppers/{shopperId}/carts/{itemId}";
}
