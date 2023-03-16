package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.Dao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Dao dao;
    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }
    @Override
    @Transactional
    public List<User> getAll() {
        return dao.getAll();
    }
    @Override
    @Transactional
    public void save(User user) { dao.save(user); }
    @Override
    @Transactional
    public User findById(Long id) { return dao.findById(id); }
    @Transactional
    @Override
    public void update(Long id,User user) { dao.update(id,user); }
    @Transactional
    @Override
    public void removeById(Long id) { dao.removeById(id); }
}