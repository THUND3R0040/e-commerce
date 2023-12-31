package Data;

import products.Product;

import java.io.FileWriter;
import java.util.Vector;

import auth.hash;

public class fileManager {
    public static void updateFile(String path,Vector<Product> products){
        try{
            FileWriter fw=new FileWriter(path);
            for (int i=0;i<products.size();i++){
                fw.write(products.get(i).name+","+products.get(i).price+","+products.get(i).category+","+products.get(i).Rating+","+products.get(i).Qt+"\n");
            }
            
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }

    public static void updateUsersFile(String path,Vector<String> users,String name){
        try{
            FileWriter fw=new FileWriter(path);
            for (int i=0;i<users.size();i++){
                if(users.get(i).contains(name)){
                    continue;
                }
                else{
                    fw.write(users.get(i)+"\n");
                }
                
            }
            
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }

    public static void addToAdminFile(String path,String name,String pass){
        try{
            FileWriter fw=new FileWriter(path,true);
            fw.write(name+" "+hash.encrypt(pass)+"\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }


}
