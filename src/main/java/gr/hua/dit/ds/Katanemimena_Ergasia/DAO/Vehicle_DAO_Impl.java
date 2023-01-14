package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.Vehicle;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class Vehicle_DAO_Impl implements Vehicle_DAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Vehicle> getAllVehicles() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Vehicle", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();
        return vehicles;
    }
}
