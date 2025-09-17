package projectCarRental;

public class MainDriver {
	public static void main(String[] args) {
		CarRentalSystem1 rentalSystem = new CarRentalSystem1();
		
		Car car1 = new Car("C001","Toyota","Camry",60.0);
		Car car2 = new Car("C002","Honda","City",70.0);
		Car car3 = new Car("C003","Toyota","Thar",150.0);
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);
		
		rentalSystem.menu();
	}
}