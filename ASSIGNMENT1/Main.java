package ASSIGNMENT1;

public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Adding some cars
        Car car1 = new Car("C001", "Corolla", "Toyota", 2020, 5000.0);
        Car car2 = new Car("C002", "Civic", "Honda", 2019, 4500.0);
        agency.addCar(car1);
        agency.addCar(car2);

        // Adding customers
        Customer cust1 = new Customer("Mary", "DL12345");
        Customer cust2 = new Customer("James", "DL54321");
        agency.addCustomer(cust1);
        agency.addCustomer(cust2);

        // Display initial info
        System.out.println("=== Initial Car Info ===");
        car1.displayInfo();
        car2.displayInfo();

        System.out.println("\n=== Customer List ===");
        agency.listCustomers();

        // Rent a car to Mary
        System.out.println("\nAttempting to rent car C001 to Mary...");
        agency.rentCar("C001", "DL12345");

        // Try renting the same car to James (should fail)
        System.out.println("\nAttempting to rent car C001 to James...");
        agency.rentCar("C001", "DL54321");

        // List rented and available cars after renting
        agency.listAvailableCars();
        agency.listRentedCars();

        // Return car C001
        System.out.println("\nReturning car C001...");
        agency.returnCar("C001");

        // Final status
        agency.listAvailableCars();
        agency.listRentedCars();
    }
}
