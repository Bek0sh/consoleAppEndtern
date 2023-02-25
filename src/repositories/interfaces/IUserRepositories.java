package repositories.interfaces;

import entities.User;

public interface IUserRepositories {

    boolean createUser(User user);
    boolean emailExists(String email);

    User AccountExists(String email,String password);

    boolean resetPassword(String email, String password);

}
