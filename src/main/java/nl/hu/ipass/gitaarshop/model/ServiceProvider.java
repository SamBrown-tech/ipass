package nl.hu.ipass.gitaarshop.model;

public class ServiceProvider {
	private static PurchaseProductService purchaseproductService = new PurchaseProductService();
	private static ProductService productService = new ProductService();
	private static PersonService personService = new PersonService();

	public static PurchaseProductService getPurchaseProductService() {
		return purchaseproductService;
	}
	
	public static ProductService getProductService() {
		return productService;
	}
	
	public static PersonService getPersonService() {
		return personService;
	}
	
}