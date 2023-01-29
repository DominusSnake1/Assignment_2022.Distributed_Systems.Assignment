package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface User_DAO {

    void deleteAllUsers();

    void save(User user);

    void delete(int id);

    @Query("Select first_name from User")
    List<User> getAllUsers();

    User findUserById(int id);

    void sellVehicle();

    void buyVehicle();
}
