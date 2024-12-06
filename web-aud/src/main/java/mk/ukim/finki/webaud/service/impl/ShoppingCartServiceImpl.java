package mk.ukim.finki.webaud.service.impl;

import mk.ukim.finki.webaud.model.Product;
import mk.ukim.finki.webaud.model.ShoppingCart;
import mk.ukim.finki.webaud.model.User;
import mk.ukim.finki.webaud.model.enume.ShoppingCartStatus;
import mk.ukim.finki.webaud.model.exception.ProductAlredyInShoppingCart;
import mk.ukim.finki.webaud.model.exception.ProductNotFound;
import mk.ukim.finki.webaud.model.exception.ShoppingCartNotFound;
import mk.ukim.finki.webaud.model.exception.UserNotFound;
import mk.ukim.finki.webaud.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.webaud.repository.jpa.UserRepository;
import mk.ukim.finki.webaud.service.ProductService;
import mk.ukim.finki.webaud.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listaAllProductsInShoppingCart(Long cartId) {

        if(!this.shoppingCartRepository.findById(cartId).isPresent()){
            throw new ShoppingCartNotFound(cartId);
        }
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFound(username));

        return this.shoppingCartRepository.findByUserAndStatus(user, ShoppingCartStatus.CREATED).orElseGet(() -> {
            ShoppingCart cart = new ShoppingCart(user);
            return this.shoppingCartRepository.save(cart);
        });

    }


    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFound(productId));
        if (shoppingCart.getProducts().stream().filter(r -> r.getId().equals(productId))
                .collect(Collectors.toList()).size() > 0) throw new ProductAlredyInShoppingCart(productId, username);
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
