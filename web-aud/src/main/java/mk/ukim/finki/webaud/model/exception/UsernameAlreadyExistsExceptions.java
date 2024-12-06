package mk.ukim.finki.webaud.model.exception;

public class UsernameAlreadyExistsExceptions extends RuntimeException{
    public UsernameAlreadyExistsExceptions(String username){
        super(String.format("User with username: %s already exists",username));

    }
}
