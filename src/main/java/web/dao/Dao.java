package web.dao;

import web.model.User;

import java.util.List;

public interface Dao {
    List<User> getAll();
    User findById(Long id);
    void save(User user);
    void update(Long id,User user);
    void removeById(Long id);
}
