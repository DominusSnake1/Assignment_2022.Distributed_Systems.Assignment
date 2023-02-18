package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.UserData;
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
        entityManager.createNativeQuery("DELETE FROM UserData WHERE user_type = 'user'").executeUpdate();
    }

    @Override
    @Transactional
    public void save(UserData userData) {
        UserData new_userData = entityManager.merge(userData);
    }

    @Override
    @Transactional
    public void delete(int id) {
        UserData userData = entityManager.find(UserData.class, id);
        entityManager.remove(userData);
    }

    @Override
    @Transactional
    public List<UserData> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from UserData", UserData.class);
        return (List<UserData>) query.getResultList();
    }

    @Override
    @Transactional
    public UserData findUserById(int id) {
        return entityManager.find(UserData.class, id);
    }

    @Override
    @Transactional
    public UserData findUserByAFM(int afm) {
        return entityManager.find(UserData.class, afm);
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
