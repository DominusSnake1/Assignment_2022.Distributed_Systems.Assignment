package gr.hua.dit.ds.Katanemimena_Ergasia.DAO;

import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.Vehicle;
import java.util.List;

public interface Vehicle_DAO {

    void deleteAllVehicles();

    void save(Vehicle vehicle);

    void delete(int id);

    List<Vehicle> getAllVehicles();

    Vehicle findVehicleById(int id);
}
