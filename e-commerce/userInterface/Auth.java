package userInterface;
import java.util.Scanner;
import auth.login.*;

public class Auth {
    static public String userName;
    static public String password;
    static public int permission;
    static public int errors=0;
    public static void firstPage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the User Interface!");
        System.out.print("Enter 1 to sign up or 2 to sign in: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        if (choice == 1) {
            
            
            System.out.println("\n=== Sign Up ===");
            System.out.print("Enter your username: ");
            String signUpUsername = scanner.nextLine();

            if (signUpUsername.isEmpty()) {
                System.out.println("Username cannot be empty. Sign Up aborted.");
                errors=1;
                return;
            } else {
                System.out.print("Enter your password: ");
                String signUpPassword = scanner.nextLine();
                if(auth.login.checkData(signUpUsername, signUpPassword, "Data/users.txt")){
                    System.out.println("Username already exists. Sign Up aborted.");
                    errors=1;
                    return;
                }
                else{
                    System.out.println("Sign Up Successful!");
                    auth.login.storeData(signUpUsername, signUpPassword, "Data/users.txt");
                    permission = 0;
                }
                
            }
        } else if (choice == 2) {
            // Sign In
            System.out.println("\n=== Sign In ===");
            System.out.print("Enter your username: ");
            String signInUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String signInPassword = scanner.nextLine();

            // User Type Selection
            System.out.println("\n=== User Type Selection ===");
            System.out.println("Select your user type:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.print("Enter your choice (1 or 2): ");
            int userTypeChoice = scanner.nextInt();
            if(userTypeChoice==1){
                if(auth.login.checkData(signInUsername, signInPassword, "Data/admins.txt")){
                    System.out.println("Welcome Admin");
                    permission=1;
                }
                else{
                    System.out.println("Invalid username or password");
                    errors=1;
                    return;
                }
            }
            else if(userTypeChoice==2){
                if(auth.login.checkData(signInUsername, signInPassword, "Data/users.txt")){
                    System.out.println("Welcome Customer");
                    permission=0;
                }
                else{
                    System.out.println("Invalid username or password");
                    errors=1;
                    return;
                };
            }
            else{
                System.out.println("Invalid choice. Please enter 1 for sign up or 2 for sign in.");
                errors=1;
                return;
            }
            // Display User Information
            
        } else {
            System.out.println("Invalid choice. Please enter 1 for sign up or 2 for sign in.");
            errors=1;
            return;
        }
        

        
    
}
}

