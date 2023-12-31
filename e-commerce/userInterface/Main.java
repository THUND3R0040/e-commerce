package userInterface;


public class Main {
    public static void main(String args[]){
        userInterface.Auth.firstPage();
        if(userInterface.Auth.errors==0){
            if(userInterface.Auth.permission==0){
            customer c = new customer();
                c.customerInterface();
            }
            else{
                Admin p = new Admin();
                p.AdminInterface();
            }
        }
        
        
    }
    
}
