package products;

public class Product {
    public String name;
    public double price;
    public String category;
    public double Rating;
    public int Qt;
    
    public Product(String name,double price,String cat,double rating,int qt){
        this.name=name;
        this.price=price;
        this.category=cat;
        this.Rating = rating;
        this.Qt = qt;

    }
    public void aff(){
        System.out.println("Category:"+name+" Price:"+price+" Description:"+category+" Rating:"+Rating+" Left In stock:"+Qt);
    }   
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    
}
