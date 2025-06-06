package ASSIGNMENT1;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Car> carList;
    private List<Customer> customerList;

    public RentalAgency() {
        carList = new ArrayList<>();
        customerList = new ArrayList<>();
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    public void addCustomer(Customer c) {
        customerList.add(c);
    }

    // Find a car by registration number (case-insensitive)
    public Car findCar(String regNum) {
        if (regNum == null) return null;
        for (Car c : carList) {
            if (c.getRegNumber().equalsIgnoreCase(regNum))
                return c;
        }
        return null;
    }

    // Find a customer by license number (case-insensitive)
    public Customer findCustomer(String licenseNum) {
        if (licenseNum == null) return null;
        for (Customer cust : customerList) {
            if (cust.getLicenseID().equalsIgnoreCase(licenseNum))
                return cust;
        }
        return null;
    }

    /**
     * Rent a car to a customer if both exist and the car is available.
     * @return true if successful, false otherwise
     */
    public boolean rentCar(String regNum, String licenseNum) {
        if (regNum == null || licenseNum == null) {
            System.out.println("Please provide valid registration and license numbers.");
            return false;
        }
        Car car = findCar(regNum);
        Customer customer = findCustomer(licenseNum);

        if (car == null) {
            System.out.println("Sorry, car with registration " + regNum + " not found.");
            return false;
        }
        if (customer == null) {
            System.out.println("Sorry, no customer with license " + licenseNum + " found.");
            return false;
        }
        if (car.isBooked()) {
            System.out.println("Car " + regNum + " is already rented.");
            return false;
        }

        car.setBooked(true);
        System.out.println("Success! Car " + regNum + " rented to " + customer.getFullName());
        return true;
    }

    /**
     * Return a rented car to the agency.
     * @return true if successful, false otherwise
     */
    public boolean returnCar(String regNum) {
        if (regNum == null) {
            System.out.println("Please provide a valid registration number.");
            return false;
        }
        Car car = findCar(regNum);

        if (car == null) {
            System.out.println("Car " + regNum + " does not exist.");
            return false;
        }
        if (!car.isBooked()) {
            System.out.println("Car " + regNum + " is not currently rented.");
            return false;
        }

        car.setBooked(false);
        System.out.println("Car " + regNum + " has been successfully returned.");
        return true;
    }

    public void listAvailableCars() {
        System.out.println("\n--- Available Cars ---");
        boolean anyAvailable = false;
        for (Car c : carList) {
            if (!c.isBooked()) {
                System.out.println(c);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) System.out.println("No cars are currently available.");
    }

    public void listRentedCars() {
        System.out.println("\n--- Rented Cars ---");
        boolean anyRented = false;
        for (Car c : carList) {
            if (c.isBooked()) {
                System.out.println(c);
                anyRented = true;
            }
        }
        if (!anyRented) System.out.println("No cars are currently rented.");
    }

    public void listCustomers() {
        System.out.println("\n--- Customers ---");
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer cust : customerList) {
                System.out.println(cust);
            }
        }
    }
}
