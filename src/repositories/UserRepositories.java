package repositories;

import data.IDB;
import entitie.User;
import repositories.interfaces.IUserRepositories;

import java.sql.*;

public class UserRepositories implements IUserRepositories {

    private final IDB idb;

    public UserRepositories(IDB idb) {
        this.idb = idb;
    }
    @Override
    public boolean createUser(User user) {
        Connection con = null;
        try {
            con = idb.getConnection();
            String sql = "INSERT INTO students(name, email, password) VALUES(?,?,?)";
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, user.getName());
            prst.setString(2, user.getEmail());
            prst.setString(3, user.getPassword());
            prst.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


    @Override
    public boolean emailExists(String email) {
        Connection con = null;
        try {
            con = idb.getConnection();
            String sql = "SELECT email FROM students WHERE email = ? limit 1";
            PreparedStatement prs = con.prepareStatement(sql);

            prs.setString(1, email);

            ResultSet rs = prs.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User AccountExists(String email, String password) {
        Connection con = null;
        try {
            con = idb.getConnection();
            String sql = "SELECT id, name, email, password FROM students WHERE password = ? AND email = ? limit 1";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, password);
            ps.setString(2, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public boolean resetPassword(String email, String password) {
        Connection con;
        try {
            con = idb.getConnection();
            String sql = "UPDATE students SET password = ? WHERE email = ?";
            // здесь пока ошибка надо исправить
            PreparedStatement prst = con.prepareStatement(sql);

            prst.setString(1, password);
            prst.setString(2,email);

            prst.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        Connection con;
        try {
            con = idb.getConnection();
            String sql = "DELETE FROM students WHERE id = ?";

            PreparedStatement prst = con.prepareStatement(sql);

            prst.setInt(1, id);

            prst.execute();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
