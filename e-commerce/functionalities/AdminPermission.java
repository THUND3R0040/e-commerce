package functionalities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import Data.fileManager;
import products.Product;

public class AdminPermission {
    public static void editProduct(){
        products.Products.loadAllProducts("Data/products.txt");
        System.out.println("Enter the name of the product you want to edit: ");
        String name = System.console().readLine();
        System.out.println("Enter the new price: ");
        double price = Double.parseDouble(System.console().readLine());
        System.out.println("Enter the new category: ");
        String category = System.console().readLine();
        System.out.println("Enter the new quantity: ");
        int qt=Integer.parseInt(System.console().readLine());

        for(int i=0;i<products.Products.ProductsForSell.size();i++){
            if(products.Products.ProductsForSell.get(i).getName().equals(name)){
                products.Products.ProductsForSell.get(i).price=price;
                products.Products.ProductsForSell.get(i).category=category;
                products.Products.ProductsForSell.get(i).Qt=qt;
            }
        }
        
        fileManager.updateFile("Data/products.txt", products.Products.ProductsForSell);
        
    }

    public static void removeUser(){
        Vector <String> usersArray = new Vector <>();
        System.out.println("Enter the name of the user you want to remove: ");
        String name = System.console().readLine();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Data/users.txt"));
            String line = reader.readLine();
            
            while(line!=null){
                usersArray.add(line);
                line = reader.readLine();
            }
            reader.close();

        }catch(Exception e){
            System.out.println("Error");
        }
        fileManager.updateUsersFile("Data/users.txt", usersArray,name);
    } 

    public static void addAdmin(){
        Vector <String> usersArray = new Vector <>();
        System.out.println("Enter the name of the admin you want to add : ");
        String name = System.console().readLine();
        System.out.println("\nEnter his Password:");
        String password = System.console().readLine();
        
        fileManager.addToAdminFile("Data/admin.txt", name,password);
    }

    public static void printMenu() {
        System.out.println("\nWelcome to Our E-commerce System!\n");
        System.out.println("1. Edit Products");
        System.out.println("2. Remove Users");
        System.out.println("3. Add new admin");
        System.out.println("4. Add new product");
        System.out.println("5. Exit");
        System.out.print("\nPlease enter the number corresponding to the action you want to perform: ");
    }

    public static void addProduct(){
        System.out.println("Enter the name of the product you want to add: ");
        String name = System.console().readLine();
        System.out.println("Enter the price: ");
        double price = Double.parseDouble(System.console().readLine());
        System.out.println("Enter the category: ");
        String category = System.console().readLine();
        System.out.println("Enter the quantity: ");
        int qt=Integer.parseInt(System.console().readLine());
        Product p = new Product(name,price,category,0,qt);
        products.Products.ProductsForSell.add(p);
        fileManager.updateFile("Data/products.txt", products.Products.ProductsForSell);
    }

}
