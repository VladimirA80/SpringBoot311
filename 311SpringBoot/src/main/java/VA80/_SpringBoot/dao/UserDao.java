package VA80._SpringBoot.dao;

import VA80._SpringBoot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(User user);

    void updateUser(User user);

}
