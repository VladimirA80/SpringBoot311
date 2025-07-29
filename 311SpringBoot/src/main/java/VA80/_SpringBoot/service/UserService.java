package VA80._SpringBoot.service;

import VA80._SpringBoot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(Long id, User user);
}
