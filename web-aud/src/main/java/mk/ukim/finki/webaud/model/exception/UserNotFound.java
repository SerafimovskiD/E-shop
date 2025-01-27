package mk.ukim.finki.webaud.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
    public UserNotFound(String username){
        super(String.format("User with id %s not found",username));
    }
}
