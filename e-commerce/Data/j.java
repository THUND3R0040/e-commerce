package Data;
import java.lang.reflect.Array;

import auth.hash.* ;
import java.io.*;
import auth.login;


public class j {
    public static void main(String[] args) 
    {   
        try{
            FileWriter fw=new FileWriter("Data/promo.txt",true);
            fw.write(auth.hash.encrypt("123456")+"\n");
            fw.write(auth.hash.encrypt("956543")+"\n"); 
            fw.write(auth.hash.encrypt("zdzezfe546")+"\n");
            fw.write(auth.hash.encrypt("zefzefef9546")+"\n");        

            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }      
}
 
        
