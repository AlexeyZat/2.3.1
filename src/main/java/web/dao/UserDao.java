package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    @Transactional
    void saveUser(User user);

    @Transactional
    void deleteUser(int id);

    @Transactional
    void updateUser(User user);
}
