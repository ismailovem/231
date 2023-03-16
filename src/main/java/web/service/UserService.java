package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void save(User user);
    User findById(Long id);
    void removeById(Long id);
    void update(Long id,User user);
}
