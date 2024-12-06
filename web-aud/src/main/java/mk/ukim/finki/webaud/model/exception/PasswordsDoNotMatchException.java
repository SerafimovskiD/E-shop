package mk.ukim.finki.webaud.model.exception;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("Passwords DoNot MatchException");
    }
}
