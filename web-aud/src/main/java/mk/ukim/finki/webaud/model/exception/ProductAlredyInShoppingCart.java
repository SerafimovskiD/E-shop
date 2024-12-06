package mk.ukim.finki.webaud.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ProductAlredyInShoppingCart extends RuntimeException{
    public ProductAlredyInShoppingCart(Long id,String username){
        super(String.format("Product with id %d alredy exist in shopping cart for user with username %s",id,username));
    }
}
