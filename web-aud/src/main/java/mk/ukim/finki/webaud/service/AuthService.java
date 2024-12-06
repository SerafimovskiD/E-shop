package mk.ukim.finki.webaud.service;

import mk.ukim.finki.webaud.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username,String password,String name,String surname,String repeatPassword);
}
