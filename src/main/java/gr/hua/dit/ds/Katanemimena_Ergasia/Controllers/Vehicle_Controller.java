package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.Vehicle_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class Vehicle_Controller {

    @Autowired
    private Vehicle_DAO_Impl vehicleDaoImpl;

    @PostMapping("/")
    public Vehicle save(@RequestBody  Vehicle vehicle) {
        vehicle.setId(0);
        vehicleDaoImpl.save(vehicle);
        return vehicle;
    }

    @DeleteMapping("/delete/")
    public void deleteAllVehicles() {
        vehicleDaoImpl.deleteAllVehicles();
    }

    @DeleteMapping("/delete/id={id}")
    public void delete(@PathVariable int id) {
        vehicleDaoImpl.delete(id);
    }

    @GetMapping("/")
    public List<Vehicle> getVehicles() {
        return vehicleDaoImpl.getAllVehicles();
    };

    @GetMapping("/id={id}")
    public Vehicle get(@PathVariable int id) {
        return vehicleDaoImpl.findVehicleById(id);
    }
}
