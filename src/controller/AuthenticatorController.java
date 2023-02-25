package controller;

import entities.User;
import repositories.interfaces.IUserRepositories;

public class AuthenticatorController {
    private final IUserRepositories ips;
    private static User authenticatedUser;

    public static User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public AuthenticatorController(IUserRepositories ips) {
        this.ips = ips;
    }

    public boolean signIn(String email, String password){
        authenticatedUser = ips.AccountExists(email, password);
        return authenticatedUser != null;
    }

    public boolean isExist(String email) {
        return ips.emailExists(email);
    }

    public String resetPassword(String email, String password) {
        boolean isReset = ips.resetPassword(email, password);
        return (isReset ? "Password was successfully reset" : "Something went wrong");
    }
}
