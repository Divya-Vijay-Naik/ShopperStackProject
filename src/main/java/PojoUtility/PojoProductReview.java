package PojoUtility;

public class PojoProductReview {
	    private String dateTime;
	    private String description;
	    private String heading;
	    private int rating;
	    private int shopperId;
	    private String shopperName;

	    // No-args constructor (needed for deserialization)
	    public PojoProductReview() {}

	    // All-args constructor
	    public PojoProductReview(String dateTime, String description, String heading,
	                  int rating, int shopperId, String shopperName) {
	        this.dateTime = dateTime;
	        this.description = description;
	        this.heading = heading;
	        this.rating = rating;
	        this.shopperId = shopperId;
	        this.shopperName = shopperName;
	    }

	    // Getters and Setters
	    public String getDateTime() {
	        return dateTime;
	    }

	    public void setDateTime(String dateTime) {
	        this.dateTime = dateTime;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getHeading() {
	        return heading;
	    }

	    public void setHeading(String heading) {
	        this.heading = heading;
	    }

	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }

	    public int getShopperId() {
	        return shopperId;
	    }

	    public void setShopperId(int shopperId) {
	        this.shopperId = shopperId;
	    }

	    public String getShopperName() {
	        return shopperName;
	    }

	    public void setShopperName(String shopperName) {
	        this.shopperName = shopperName;
	    }
	}


