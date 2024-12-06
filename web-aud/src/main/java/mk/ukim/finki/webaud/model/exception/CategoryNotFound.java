package mk.ukim.finki.webaud.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class CategoryNotFound extends RuntimeException
{
    public CategoryNotFound(Long id){
        super(String.format("Category with id %d was not Found ",id));
    }
}
