package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUser() {
        List<User> AllUser = entityManager.createQuery("select u from User u", User.class).getResultList();
        return AllUser;
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void addUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        TypedQuery<User> typedQuery = (TypedQuery<User>) entityManager.createQuery("delete from User where id =: userId"); //
        typedQuery.setParameter("userId", id);
        typedQuery.executeUpdate();
    }


}