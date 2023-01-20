package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.User_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.Vehicle_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.User;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class Vehicle_Controller {

    @Autowired
    private Vehicle_DAO_Impl vehicleDaoImpl;
    @Autowired
    private User_DAO_Impl userDaoImpl;

    @PostMapping("/owner_id={o_id}")
    public Vehicle save(@PathVariable int o_id, @RequestBody Vehicle vehicle) {
        User user = userDaoImpl.findUserById(o_id);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + o_id + ", is not found.");
        }

        vehicle.setOwner_id(o_id);
        vehicle.setId(0);
        vehicleDaoImpl.save(vehicle);
        return vehicle;
    }

    @DeleteMapping("admin/delete/")
    public void deleteAllVehicles() {
        vehicleDaoImpl.deleteAllVehicles();
    }

    @DeleteMapping("admin/delete/id={id}")
    public void delete(@PathVariable int id) {
        vehicleDaoImpl.delete(id);
    }

    @GetMapping("/")
    public List<Vehicle> getVehicles() {
        return vehicleDaoImpl.getAllVehicles();
    };

    @GetMapping("/id={id}")
    public Vehicle get(@PathVariable int id) {return vehicleDaoImpl.findVehicleById(id);}
}
