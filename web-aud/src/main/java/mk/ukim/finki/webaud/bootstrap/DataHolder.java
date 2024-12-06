package mk.ukim.finki.webaud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.webaud.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<Category>categories=new ArrayList<>();
    public static List<User>users=new ArrayList<>();
    public static List<Product>products=new ArrayList<>();
    public static List<Manufacturer>manufacturers=new ArrayList<>();
    public static List<ShoppingCart>shoppingCarts=new ArrayList<>();
//    @PostConstruct
//    public void init(){
//        categories.add(new Category("Books","Books category"));
//        categories.add(new Category("Movies","Movies category"));
//
//        users.add(new User("dame","ds","Damjan","Serafimovski"));
//        users.add(new User("riki","rs","Riste","Stojanov"));
//        users.add(new User("koki","km","Kostadin","Mishev"));
//
//        Manufacturer manufacturer=new Manufacturer("Nike","NY NY");
//        Manufacturer manufacturer1=new Manufacturer("Adidas","AD AD");
//        manufacturers.add(manufacturer);
//        manufacturers.add(manufacturer1);
//        Category category=new Category("Sport ","Sport-Category");
//        categories.add(category);
//        products.add(new Product("Nike Ordem 4 ",890.0,10,category,manufacturer));
//        products.add(new Product("Nike Maxim",750.0,9,category,manufacturer));
//        products.add(new Product("Nike Ordem V",550.0,6,category,manufacturer));
//    }
}
