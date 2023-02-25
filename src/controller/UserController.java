package controller;

import entities.User;
import repositories.interfaces.IUserRepositories;

public class UserController {
    private final IUserRepositories repo;

    public UserController(IUserRepositories repo) {
        this.repo = repo;
    }

    public String createUser(String name, String email,String password) {
        User user = new User(name, email, password);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!");
    }







}
