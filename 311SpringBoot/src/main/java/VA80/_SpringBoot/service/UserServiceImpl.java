package VA80._SpringBoot.service;

import VA80._SpringBoot.dao.UserDao;
import VA80._SpringBoot.model.User;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        User user = userDao.getUser(id);
        if (user == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userDao.getUser(id);
        if (user == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
        userDao.deleteUser(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User existingUser = userDao.getUser(id);
        if (existingUser == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
        existingUser.setFirstName(user.getFirstName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        userDao.updateUser(existingUser);
    }
}
