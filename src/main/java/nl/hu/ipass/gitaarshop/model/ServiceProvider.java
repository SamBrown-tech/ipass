package nl.hu.ipass.gitaarshop.model;

public class ServiceProvider {
	private static ProductService productService = new ProductService();
	private static PersonService personService = new PersonService();

	public static ProductService getProductService() {
		return productService;
	}
	
	public static PersonService getPersonService() {
		return personService;
	}
}