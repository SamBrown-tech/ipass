package nl.hu.ipass.gitaarshop.model;

import java.util.Date;

public class PurchaseProduct {
	private int purchaseproduct_id;
	private int purchase_id;
	private int product_id;
	private int quantity;

	// Getters
	public int getPurchaseProductId() {
		return purchaseproduct_id;
	}
	
	public int getPurchaseId() {
		return purchase_id;
	}
	
	public int getProductId() {
		return product_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	// Setters

	public void setPurchaseProductId(int purchaseproduct_id) {
		this.purchaseproduct_id = purchaseproduct_id;
	}
	
	public void setPurchaseId(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	
	public void setProductId(int product_id) {
		this.product_id = product_id;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
