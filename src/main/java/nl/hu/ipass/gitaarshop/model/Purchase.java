package nl.hu.ipass.gitaarshop.model;

public class Purchase {
    private int bestelling_id;
    private int product_id;
    private String name;
    private int quantity;
    private double price;
    private String email;

    
	public int getBestellingId() {
		return bestelling_id;
	}

	public void setBestellingId(int bestelling_id) {
		this.bestelling_id = bestelling_id;
	}

	public int getProductId() {
		return product_id;
	}

	public void setProductId(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}