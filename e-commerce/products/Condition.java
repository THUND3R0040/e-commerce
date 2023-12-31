package products;

import java.util.Vector;

public class Condition {
    public static  void Exec1(String []parts,Vector<Product> ProductsForSell){
        if (parts.length >= 4) {
                        String name = parts[0];
                        Double price = Double.parseDouble(parts[1]);
                        String categ = parts[2];
                        Double rating = Double.parseDouble(parts[3]);
                        int qt = Integer.parseInt(parts[4]);
                        ProductsForSell.add(new Product(name, price, categ, rating,qt));
                    }
    }
    public static void Exec2(String []parts,String category,Vector<Product> ProductsForSell){
        if (parts.length >= 4 && parts[2].equals(category)) {
                        String name = parts[0];
                        Double price = Double.parseDouble(parts[1]);
                        String categ = parts[2];
                        Double rating = Double.parseDouble(parts[3]);
                        int qt=Integer.parseInt(parts[4]);
                        ProductsForSell.add(new Product(name, price, categ, rating,qt));
                    }
    }
    public static void Exec3(String []parts,double min,double max,Vector<Product> ProductsForSell){

        if (parts.length >= 4 && Double.parseDouble(parts[1])>=min && Double.parseDouble(parts[1])<=max) {
                        String name = parts[0];
                        Double price = Double.parseDouble(parts[1]);
                        String categ = parts[2];
                        Double rating = Double.parseDouble(parts[3]);
                        int qt = Integer.parseInt(parts[4]);
                        ProductsForSell.add(new Product(name, price, categ, rating,qt));
                    }
    }
    public static void Exec4(String []parts,double min,double max,Vector<Product> ProductsForSell){
        if (parts.length >= 4 && Double.parseDouble(parts[3])>=min && Double.parseDouble(parts[3])<=max) {
                        String name = parts[0];
                        Double price = Double.parseDouble(parts[1]);
                        String categ = parts[2];
                        Double rating = Double.parseDouble(parts[3]);
                        int qt = Integer.parseInt(parts[4]);
                        ProductsForSell.add(new Product(name, price, categ, rating,qt));
                    }
    }
}
