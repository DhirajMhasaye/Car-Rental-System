package projectCarRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem1 {

	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	/**
	 * @param cars
	 * @param customers
	 * @param rentals
	 */
	public CarRentalSystem1() {
		super();
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void rentCar(Car car, Customer customer, int days) {
		if (car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car,customer,days));
		}
		else
			System.out.println("Car is not available for rent");
	}
	
	public void returnCar(Car car) {
		//car.returnCar(); // TBC
		car.rent(); 
		Rental rentalToRemove = null;
		
		for (Rental rental : rentals) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}
		
		if (rentalToRemove != null) 
			rentals.remove(rentalToRemove);
		else
			System.out.println("Car was not rented");
	}
	
	public void menu() {
	Scanner sc = new Scanner(System.in);
	
	while(true) {
		
		System.out.println("==== Welcome to Car Rental System ====");
		System.out.println("1. Rent a Car");
		System.out.println("2. Return a Car");
		System.out.println("3. Exit");
		System.out.println("Enter your choice");
		
		int choice = sc.nextInt();
		sc.nextLine(); //Bring cursor to nextLine/ newLine
		
		if(choice == 1) {
			System.out.println("== Rent a Car ==");
			
			System.out.println("Enter your name: ");
			String customerName = sc.nextLine(); // Customer name is stored temporarily
			
			// for loop to print all available cars in the cars ArrayList;
			System.out.println("\n Available Cars: ");
			for(Car car : cars) {
				if(car.isAvailable()) {
					System.out.println(car.getCarId() + "-" + car.getBrand() + car.getModel());
				}
			}
			
			System.out.println("\n Enter the car ID you want to rent: ");
			String carId = sc.nextLine();
			
			System.out.println("Enter the number of days for rental: ");
			int rentalDays = sc.nextInt();
			sc.nextLine();
			
			
			// Object of Customer to add customer name in customer ArrayList in format:- "CUS1Soham" 
			Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
			addCustomer(newCustomer); // Calling addCustomer to add newCustomer details
			
			Car selectedCar = null;
			for(Car car : cars) {
				// car.getCarId().equals(carId) checks that the carId the customer want 
				// to get on rent is equal to the available car list. 
				if(car.getCarId().equals(carId) && car.isAvailable()) {
					selectedCar = car;
					break;
				}
			}
			
			if(selectedCar != null) {
				//calculate the price of rental
				double totalPrice = selectedCar.calculatePrice(rentalDays);

				System.out.println("\n== Rental Information ==\n");
				System.out.println("Cutomer ID: " + newCustomer.getCustomerId());
				System.out.println("Cutomer Name: " + newCustomer.getName());
				System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
				System.out.println("Rental Days: " + rentalDays);
				System.out.println("Total Price: $%.2f%n" + totalPrice); //TBC
				
				System.out.println("\n Confirm Rental (Y/N): ");
				String confirm = sc.nextLine();
				
				if(confirm.equalsIgnoreCase("Y")) {
					rentCar(selectedCar, newCustomer, rentalDays); //TBC
					
					System.out.println("\n Car rented successfully.");	
				}
				else {
					System.out.println("\n Rental Canceled");
				}	
			}
			
			else {
				System.out.println("\n Invalid car selection or car not available for rent");
			}
		
		}
		
		else if(choice == 2) {
			
				System.out.println("\n == Return Car ==");
				System.out.println("Enter the car ID you want to return: ");
				String carId = sc.nextLine();
				
				Car carToReturn = null;
				for(Car car : cars) {
					if(car.getCarId().equals(carId) && !car.isAvailable()) {
						carToReturn = car;
						break;
					}
				}
				
				if(carToReturn != null) {
					Customer customer = null;
					for(Rental rental : rentals) {
						if(rental.getCar() == carToReturn) {
							customer = rental.getCustomer();
							break;
						}
					}
					if(customer != null) {
						returnCar(carToReturn);
						System.out.println("Car Successfully returned by" + customer.getName());
					}
					else {
						System.out.println("Car was not rented or rental information is missing.");
					}
				}
				
				else {
					System.out.println("Invalid car ID or car is not rented.");
				}		
			}

		else if(choice == 3) {
			break;
		}
		
		else {
			System.out.println("Invalid choice. Please enter a valid option.");
		}
	}

	System.out.println("\n Thank you for using the Car Rental System! \n");	
	
	
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
////	Creating ArrayList for each module
//	private List<Car> cars;
//	
//	private List<Customer> customers;
//	
//	private List<Rental> rentals;
//	
//	
//	public CarRentalSystem() {
//		cars = new ArrayList<>();
//		customers = new ArrayList<>();
//		rentals = new ArrayList<>();
//	}
//	
//	
////	method to add new Car
//	public void addCar(Car car) {
//		cars.add(car);
//	}
//	
////	method to add new Customer
//	public void addCustomer(Customer customer) {
//		customers.add(customer);
//	}
//	
////	method to add new rental details
//	public void rentCar(Car car, Customer customer, int days) {
//		if(car.isAvailable()) {
//			car.rent();
//			rentals.add(new Rental(car, customer, days));
//		}
//		else {
//			System.out.println("Car is not available for rent.");
//		}
//	}
//	
////	method to return the car
//	public void returnCar(Car car) {
//		// make isAvailable status to true
////		car.returnCar();   
//		car.rent();   
//		// variable to store rental object in ArrayList
//		Rental rentalToRemove = null;   
//		//forEach loop is used to iterate through rentals ArrayList
//		//Syntax:- for (dataType variable : arrayListName){}
//		for (Rental rental : rentals) {   
//			if(rental.getCar() == car) {
//				rentalToRemove = rental;
//				break;
//			}
//		}
//		
//		if(rentalToRemove != null) {
//			rentals.remove(rentalToRemove);	
//		}
//		else {
//			System.out.println("Car was not rented");
//		}
//	}
//	
//	
////	Menu Method to declare the format
//	public void menu() {
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			
//			System.out.println("==== Welcome to Car Rental System ====");
//			System.out.println("1. Rent a Car");
//			System.out.println("2. Return a Car");
//			System.out.println("3. Exit");
//			System.out.println("Enter your choice");
//			
//			int choice = sc.nextInt();
//			sc.nextLine(); //Bring cursor to nextLine/ newLine
//			
//			if(choice == 1) {
//				System.out.println("== Rent a Car ==");
//				
//				System.out.println("Enter your name: ");
//				String customerName = sc.nextLine(); // Customer name is stored temporarily
//				
//				// for loop to print all available cars in the cars ArrayList;
//				System.out.println("\n Available Cars: ");
//				for(Car car : cars) {
//					if(car.isAvailable()) {
//						System.out.println(car.getCarId() + "-" + car.getBrand() + car.getModel());
//					}
//				}
//				
//				System.out.println("\n Enter the car ID you want to rent: ");
//				String carId = sc.nextLine();
//				
//				System.out.println("Enter the number of days for rental: ");
//				int rentalDays = sc.nextInt();
//				sc.nextLine();
//				
//				
////				Object of Customer to add customer name in customer ArrayList in format:- "CUS1Soham" 
//				Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
//				addCustomer(newCustomer); // Calling addCustomer to add newCustomer details
//				
//				Car selectedCar = null;
//				for(Car car : cars) {
//					// car.getCarId().equals(carId) checks that the carId the customer want 
//					// to get on rent is equal to the available car list. 
//					if(car.getCarId().equals(carId) && car.isAvailable()) {
//						selectedCar = car;
//						break;
//					}
//				}
//				
//				if(selectedCar != null) {
//					//calculate the price of rental
//					double totalPrice = selectedCar.calculatePrice(rentalDays);
//					
//					
//					System.out.println("\n== Rental Information ==\n");
//					System.out.println("Cutomer ID: " + newCustomer.getCustomerId());
//					System.out.println("Cutomer Name: " + newCustomer.getName());
//					System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
//					System.out.println("Rental Days: " + rentalDays);
//					System.out.println("Total Price: $%.2f%n" + totalPrice); //TBC
//					
//					System.out.println("\n Confirm Rental (Y/N): ");
//					String confirm = sc.nextLine();
//					
//					if(confirm.equalsIgnoreCase("Y")) {
//						rentCar(selectedCar, newCustomer, rentalDays); //TBC
//						
//						System.out.println("\n Car rented successfully.");	
//					}
//					else {
//						System.out.println("\n Rental Canceled");
//					}	
//				}
//				
//				else {
//					System.out.println("\n Invalid car selection or car not available for rent");
//				}
//				
//			}	
//				else if(choice == 2) {
//				
//					System.out.println("\n == Return Car ==");
//					System.out.println("Enter the car ID you want to return: ");
//					String carId = sc.nextLine();
//					
//					Car carToReturn = null;
//					for(Car car : cars) {
//						if(car.getCarId().equals(carId) && !car.isAvailable()) {
//							carToReturn = car;
//							break;
//						}
//					}
//					
//					if(carToReturn != null) {
//						Customer customer = null;
//						for(Rental rental : rentals) {
//							if(rental.getCar() == carToReturn) {
//								customer = rental.getCustomer();
//								break;
//							}
//						}
//						if(customer != null) {
//							returnCar(carToReturn);
//							System.out.println("Car Successfully returned by" + customer.getName());
//						}
//						else {
//							System.out.println("Car was not rented or rental information is missing.");
//						}
//					}
//					
//					else {
//						System.out.println("Invalid car ID or car is not rented.");
//					}		
//				}
//			
//				else if(choice == 3) {
//					break;
//				}
//				
//				else {
//					System.out.println("Invalid choice. Please enter a valid option.");
//				}
//			}
//		
//			System.out.println("\n Thank you for using the Car Rental System! \n");	
//		}
//	}