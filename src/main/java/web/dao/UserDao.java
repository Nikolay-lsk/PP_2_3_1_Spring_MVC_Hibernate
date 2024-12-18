package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void saveUser(User user);

    void addUser(User user);

    User getUserById(long id);

    public User getUser(long id);

    public void deleteUser(long id);
}
