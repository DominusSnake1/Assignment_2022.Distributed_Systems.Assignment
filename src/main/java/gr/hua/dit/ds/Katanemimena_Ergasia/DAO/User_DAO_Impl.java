package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class User_DAO_Impl implements User_DAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteAllUsers() {
        entityManager.createNativeQuery("DELETE FROM Users WHERE user_type = 'user'").executeUpdate();
    }

    @Override
    @Transactional
    public void save(User user) {
        User new_user = entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void sellVehicle() {

    }

    @Override
    @Transactional
    public void buyVehicle() {

    }
}
