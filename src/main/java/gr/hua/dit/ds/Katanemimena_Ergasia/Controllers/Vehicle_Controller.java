package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.Interested_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.User_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.Vehicle_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.UserData;
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

    @Autowired
    private Interested_DAO_Impl interestedDaoImpl;

    @PostMapping("/owner_afm={o_afm}")
    public Vehicle save(@PathVariable int o_afm, @RequestBody Vehicle vehicle) {
        UserData userData = userDaoImpl.findUserByAFM(o_afm);

//        if (userData == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with afm: " + o_afm + ", is not found.");
//        }

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

    @GetMapping("/interested/regis={regis}")
    public void showInterest(@PathVariable String regis, int own_afm) {
        interestedDaoImpl.showInterest(regis, own_afm);
    }
}
