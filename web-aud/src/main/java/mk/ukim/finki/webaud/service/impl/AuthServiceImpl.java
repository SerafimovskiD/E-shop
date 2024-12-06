package mk.ukim.finki.webaud.service.impl;

import mk.ukim.finki.webaud.model.User;
import mk.ukim.finki.webaud.model.exception.InvalidArgumentsExecption;
import mk.ukim.finki.webaud.model.exception.InvalidUserCredentialException;
import mk.ukim.finki.webaud.model.exception.PasswordsDoNotMatchException;
import mk.ukim.finki.webaud.model.exception.UsernameAlreadyExistsExceptions;
import mk.ukim.finki.webaud.repository.jpa.UserRepository;
import mk.ukim.finki.webaud.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsExecption();
        }
        return userRepository.findByUsernameAndPassword(username,password)
                .orElseThrow(InvalidUserCredentialException::new);
    }

    @Override
    public User register(String username, String password, String name, String surname, String repeatPassword) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsExecption();
        }
        if(password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        if(this.userRepository.findByUsername(username).isPresent()|| !this.userRepository.findByUsername(username).isEmpty()){
            throw new UsernameAlreadyExistsExceptions(username);
        }
        User user=new User(username,password,name,surname);
        userRepository.save(user);
        return user;
    }
}
