package functionalities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import products.Product;
import products.Products;
import Data.fileManager;

public class cutomerFunc {
    public static void printMenu() {
        System.out.println("\nWelcome to Our E-commerce System!\n");
        System.out.println("1. View Products");
        System.out.println("2. View Shopping Cart");
        System.out.println("3. Add Item to Cart");
        System.out.println("4. Update Cart Item");
        System.out.println("5. Remove Item from Cart");
        System.out.println("6. Proceed to Checkout");
        System.out.println("7. Rate Items");
        System.out.println("8. Exit");
        System.out.print("\nPlease enter the number corresponding to the action you want to perform: ");
    }
    public static void showProducts(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== View Products ===");
                    System.out.println("1. View All Products");
                    System.out.println("2. View Products by Category");
                    System.out.println("3. View Products by Price Range");
                    System.out.println("4. View Products by Rating");
                    System.out.print("Enter your choice (1-4): ");
                    int viewProductsChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    switch (viewProductsChoice) {
                        case 1:
                            // View All Products
                            System.out.println("\n=== View All Products ===");
                            
                            products.Products.loadAllProducts("Data/products.txt");
                            products.Products.printProducts();
                            break;
                        case 2:
                            // View Products by Category
                            System.out.println("\n=== View Products by Category ===");
                            System.out.print("Enter the category: ");
                            String category = scanner.nextLine();
                            products.Products.loadProductsByCat("Data/products.txt",category);
                            products.Products.printProducts();
                            break;
                        case 3:
                            // View Products by Price Range
                            System.out.println("\n=== View Products by Price Range ===");
                            System.out.print("Enter the minimum price: ");
                            double minPrice = scanner.nextDouble();
                            System.out.print("Enter the maximum price: ");
                            double maxPrice = scanner.nextDouble();
                            products.Products.loadProductsByPrice("Data/products.txt",minPrice,maxPrice);
                            products.Products.printProducts();
                            break;
                        case 4:
                            // View Products by Rating
                            System.out.println("\n=== View Products by Rating ===");
                            System.out.print("Enter the minimum rating: ");
                            double minRating = scanner.nextDouble();
                            System.out.print("Enter the maximum rating: ");
                            double maxRating = scanner.nextDouble();
                            products.Products.loadProductsByRating("Data/products.txt",minRating,maxRating);
                            products.Products.printProducts();
                            break;
    } 

}
    public static void addCartItem(Vector<Product> cart){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Add Item to Cart ===");
        System.out.print("Enter the name of the product: ");
        String name = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
                    
        Products.loadAllProducts("Data/products.txt");
        for(int i=0;i<Products.ProductsForSell.size();i++){
            
            if(Products.ProductsForSell.get(i).getName().equals(name)){
                if(Products.ProductsForSell.get(i).Qt<quantity){
                    System.out.println("Sorry we don't have enough quantity of this product");
                    return;
                }
                cart.add(Products.ProductsForSell.get(i));
                cart.get(cart.size()-1).price = quantity*cart.get(cart.size()-1).price;
                cart.get(cart.size()-1).Qt = quantity;
            }
        }
        
    }

    public static void editQt(Vector<Product> cart){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Edit Item Quantity ===");
        System.out.print("Enter the name of the product: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter the new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getName().equals(name1)){
                cart.get(i).price=quantity*(cart.get(i).price/(cart.get(i).Qt));
                cart.get(i).Qt = quantity;
            }
        }
        
    }
    
    public static void removeCartItem(Vector<Product> cart){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Remove Item from Cart ===");
        System.out.print("Enter the name of the product: ");
        String name2 = scanner.nextLine();
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getName().equals(name2)){
                cart.remove(i);
            }
        }
    }

    public static double checkout(Vector<Product> cart){
        double total = 0;
        for(int i=0;i<cart.size();i++){
            total+=cart.get(i).price;
        }
        return total;
    }

    private static boolean checkInclusion(Vector<Product>cart,String name ){
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).name.equals(name)){
                return true;
            }
        }
        return false;
    }

    
        public static void completeOrder(Vector<Product>cart){
            

            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your payment method (e.g., Credit Card, PayPal): ");
            String paymentMethod = scanner.nextLine();

            System.out.println("Please enter your shipping address: ");
            String shippingAddress = scanner.nextLine();

            // Add more questions as needed...

            double total = 0.0;
            System.out.println("\n=== Completing Order ===");
            System.out.println("Items in your cart:");
            for (int i =0;i<cart.size();i++) {
                System.out.println("- " + cart.get(i).getName() + ": " + cart.get(i).getPrice());
                total += cart.get(i).getPrice();
            }

            System.out.println("Total: " + total);
            System.out.println("Payment Method: " + paymentMethod);
            System.out.println("Shipping Address: " + shippingAddress);
            //promo code
            System.out.println("Do you have a promo code? (Y/N)");
            String promo = scanner.nextLine();
            if(promo.equals("Y")){
                System.out.println("Enter your promo code: ");
                String code = scanner.nextLine();
                boolean test = false;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Data/promo.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if(line.contains(auth.hash.encrypt(code))){
                            reader.close();
                            test = true;
                    }   }
        
                    reader.close();
                }
                catch (IOException e){
                    
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                
                if(test){
                    System.out.println("Promo Code is valid!");
                    total = total*0.9;
                }
                else{
                    System.out.println("Promo Code is invalid!");
                }
            }


            System.out.println("Total: " + total);
            cart.clear();
            System.out.println("Order completed. Thank you for your purchase!");

            try{
                FileWriter fw=new FileWriter("Data/Orders.txt",true);
                fw.write("An Order with the amount "+total+" has been completed with this Shipping Adress: "+shippingAddress+"\n");
                fw.close();
            }
            catch(Exception e){
                System.out.println(e);
            } 
    }        
    

    public static void rateItems(Vector<Product> cart){
        for(int i =0;i<cart.size();i++){
            cart.get(i).aff();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Rate Items ===");
        System.out.print("Enter the name of the product ( You can only rate products included in ur cart ) : ");
        String name3;
        do{
            name3 = scanner.nextLine();
        }while(checkInclusion(cart,name3)==false);

        System.out.print("Enter the rating: ");
        double rating = scanner.nextDouble();
        Products.loadAllProducts("Data/products.txt");
        scanner.nextLine(); // Consume the newline character
        for(int i=0;i<Products.ProductsForSell.size();i++){
            if(Products.ProductsForSell.get(i).getName().equals(name3)){
                Products.ProductsForSell.get(i).Rating = (rating+Products.ProductsForSell.get(i).Rating)/2;
            }
        }
        fileManager.updateFile("Data/products.txt",Products.ProductsForSell);
        
    }

}