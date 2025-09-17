package projectCarRental;

public class Customer {
	
	private String name;
	
	private String customerId;
	
	public Customer(String customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
}