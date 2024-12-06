package mk.ukim.finki.webaud.service;

import mk.ukim.finki.webaud.model.Product;
import mk.ukim.finki.webaud.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Product> listaAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);

}
