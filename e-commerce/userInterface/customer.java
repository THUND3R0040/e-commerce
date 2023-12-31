package userInterface;

import java.util.Vector;

import functionalities.cutomerFunc;
import products.Product;

import java.util.Scanner;

public class customer {
    
    
    
    public Vector<Product> cart = new Vector<>();
           
    
    public void customerInterface() {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            cutomerFunc.printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    // View Products
                    cutomerFunc.showProducts();
                    break;
                case 2:
                    // View Shopping Cart
                    System.out.println("\n=== View Shopping Cart ===");
                    for(int i =0;i<cart.size();i++){
                        cart.get(i).aff();
                    }
                    break;
                case 3:
                    // Add Item to Cart
                    cutomerFunc.addCartItem(cart);
                    System.out.println("\nWould you like to complete your Order:");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Enter your choice (1-2): ");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if(choice2==1){
                        cutomerFunc.completeOrder(cart);
                    }
                    break;
                case 4:
                    // Edit Item Quantity
                    cutomerFunc.editQt(cart);
                    break;
                case 5:
                    // Remove Item from Cart
                    cutomerFunc.removeCartItem(cart);
                    break;
                case 6:
                    // Checkout
                    cutomerFunc.completeOrder(cart);
                case 7:
                    // rating items
                    cutomerFunc.rateItems(cart);
                    break;
            }
            
        } while (choice != 8);
        
}
    
}
