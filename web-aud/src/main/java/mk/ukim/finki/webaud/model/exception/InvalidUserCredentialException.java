package mk.ukim.finki.webaud.model.exception;

public class InvalidUserCredentialException extends RuntimeException{
    public InvalidUserCredentialException(){
        super("Invalid User Credential Exception");
    }
}
