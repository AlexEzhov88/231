package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void update(User user) {
        getById(user.getId()).setName(user.getName());
        getById(user.getId()).setAge(user.getAge());
        getById(user.getId()).setEmail(user.getEmail());
        entityManager.merge(getById(user.getId()));
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}