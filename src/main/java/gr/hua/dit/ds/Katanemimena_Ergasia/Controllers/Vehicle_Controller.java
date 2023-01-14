package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.Vehicle_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class Vehicle_Controller {

    @Autowired
    private Vehicle_DAO_Impl vehicleDaoImpl;

    @GetMapping("/")
    public List<Vehicle> getVehicles() {
        return vehicleDaoImpl.getAllVehicles();
    };
}
