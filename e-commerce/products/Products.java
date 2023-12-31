package products;


import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import products.Condition;

    public class Products {
        
        public static Vector<Product> ProductsForSell = new Vector<>();

        public static void loadAllProducts(String filePath) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    products.Condition.Exec1(parts, ProductsForSell);
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void loadProductsByCat(String filePath,String cat) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    products.Condition.Exec2(parts,cat, ProductsForSell);
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void loadProductsByPrice(String filePath,double min,double max) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    products.Condition.Exec3(parts,min,max, ProductsForSell);
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void loadProductsByRating(String filePath,double min,double max) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    products.Condition.Exec4(parts,min,max,ProductsForSell);
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }




        static public void printProducts() {
            for (int i = 0; i < ProductsForSell.size(); i++) {
                ProductsForSell.get(i).aff();
            }
        }
    }

