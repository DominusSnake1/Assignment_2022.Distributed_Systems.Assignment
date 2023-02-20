package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class Interested_DAO_Impl implements Interested_DAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void showInterest(String registration, int own_afm) {

    }
}
