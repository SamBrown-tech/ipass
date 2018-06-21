package nl.hu.ipass.gitaarshop.model;

public class Product {
	private int product_id;
	private String name;
	private String description;
	private String image;
	private double price;
	
	// Getters
	public int getProductId() {
		return product_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImage() {
		return image;
	}
	
	public double getPrice() {
		return price;
	}

	// Setters
	public void setProductId(int product_id) {
		this.product_id = product_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}