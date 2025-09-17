package projectCarRental;

public class Car
{
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	/**
	 * @param carId
	 * @param brand
	 * @param model
	 * @param basePricePerDay
	 * @param isAvailable
	 */
	public Car(String carId, String brand, String model, double basePricePerDay) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;
	}
	
	// Getter to get the values 
	public String getCarId() {
		return carId;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}
	
	// TBC -> to Display base price list of each vehicle 
	public double getBasePricePerDay() {
		return basePricePerDay;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	} 
	
	// calculate the total rental price
	public double calculatePrice(int rentalDays)
	{
		return basePricePerDay * rentalDays;
	}

	public void rent() {
		isAvailable = false;
	}
	
}