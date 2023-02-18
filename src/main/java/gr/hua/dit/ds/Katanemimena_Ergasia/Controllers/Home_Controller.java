package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home_Controller {

    @RequestMapping("/")
    public String adminHome() {return "HomePage";}

    @RequestMapping("/newUsers")
    public String createUser() {return "User/createUser";}

    @RequestMapping("/newVehicles")
    public String addVehicle() {return "Vehicle/addVehicle";}
}
