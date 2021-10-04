//min max code
package Streamapi;
import java.util.*;
class Product{
    int id;
    String name;
    int price;
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class JavaStreamExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products    
        productsList.add(new Product(1,"HP Laptop",25000));
        productsList.add(new Product(2,"Dell Laptop",30000));
        productsList.add(new Product(3,"Lenevo Laptop",28000));
        productsList.add(new Product(4,"Sony Laptop",2800));
        productsList.add(new Product(5,"Apple Laptop",90000));
        // implement max
        Product productA = productsList.stream().max((product1, product2)->product1.price > product2.price ? 1: -1).get();
        System.out.println(productA.price);
        Product productA1 = productsList.stream().min((product1, product2)->product1.price < product2.price ? 1: -1).get();
        System.out.println(productA1.price);

        // implement min
        Product productB = productsList.stream().min((product1, product2)->product1.price > product2.price ? 1: -1).get();
        System.out.println(productB.price);
        Product productB1 = productsList.stream().max((product1, product2)->product1.price < product2.price ? 1: -1).get();
        System.out.println(productB1.price);

    }
}    