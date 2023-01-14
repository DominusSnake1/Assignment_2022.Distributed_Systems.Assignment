package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.User;
import java.util.List;

public interface User_DAO {

    public List<User> getAllUsers();

    public void sellVehicle();

    public void buyVehicle();
}
