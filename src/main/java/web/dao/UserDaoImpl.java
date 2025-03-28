package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() == 0 || entityManager.find(User.class, user.getId()) == null) {
            throw new IllegalArgumentException("User does not exist");
        }
        entityManager.merge(user);
    }
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

}
     // если использовать persist() выдает ошибку при изменении, поэтому исправил на merge()