package auth;

import java.io.*;
import auth.hash.*;

import java.util.ArrayList;
import java.util.Arrays;

public class login {
    public static void storeData(String userName,String Pass,String path){

        
        try{
            FileWriter fw=new FileWriter(path,true);
            fw.write(userName+" "+auth.hash.encrypt(Pass)+"\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        } 
        
}

public static boolean checkData(String userName,String pass,String path){
    try {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
                if(line.contains(userName) && line.contains(auth.hash.encrypt(pass))){
                    reader.close();
                    return true;
                }
        }
        reader.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;

            

}
    


}