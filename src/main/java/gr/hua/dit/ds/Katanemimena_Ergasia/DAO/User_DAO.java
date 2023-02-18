package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.UserData;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface User_DAO {

    void deleteAllUsers();

    void save(UserData userData);

    void delete(int id);

    @Query("Select first_name from UserData")
    List<UserData> getAllUsers();

    UserData findUserById(int id);

    UserData findUserByAFM(int afm);

    void sellVehicle();

    void buyVehicle();
}
