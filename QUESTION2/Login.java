package Question2;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // Set the correct username and password
        String validUsername = "user";
        String validPassword = "user890";

        int attempts = 3; // Number of allowed login attempts

        Scanner scanner = new Scanner(System.in);

        // Loop until the user runs out of attempts or logs in successfully
        do {
            System.out.print("Please enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();

            // Check if entered credentials are correct
            if (username.equals(validUsername) && password.equals(validPassword)) {
                System.out.println("Login successful! Welcome.");
                break;  // Exit loop on successful login
            } else {
                attempts--;  // Deduct one attempt
                if (attempts > 0) {
                    System.out.println("Incorrect credentials. Please try again.");
                    System.out.println("Remaining attempts: " + attempts);
                } else {
                    System.out.println("Sorry, no attempts left. Access denied.");
                }
            }
        } while (attempts > 0);

        scanner.close(); // Close scanner resource
    }
}
 
    

