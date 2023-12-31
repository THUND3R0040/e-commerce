package userInterface;
import java.util.Scanner;

import functionalities.AdminPermission;
public class Admin{
    
    public  void AdminInterface() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            AdminPermission.printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    AdminPermission.editProduct();
                    break;
                case 2:
                    AdminPermission.removeUser();
                    break;
                case 3:
                    AdminPermission.addAdmin();
                    break;
                case 4:
                    AdminPermission.addProduct();
                    break;
            }
        }while(choice!=5);
   

}}
