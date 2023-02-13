package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void add(User user);

    public void deleteById(Long id);

    void update(User user);

    public User getById(long id);

}

