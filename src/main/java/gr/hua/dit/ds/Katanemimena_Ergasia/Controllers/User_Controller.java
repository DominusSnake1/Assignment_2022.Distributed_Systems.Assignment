package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.User_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(value = "https://127.0.0.1:8080", maxAge = 3600)
@RequestMapping("/users")
public class User_Controller {

    @Autowired
    private User_DAO_Impl userDaoImpl;

    @PostMapping("/add")
    public UserData save(@RequestBody UserData userData) {
        userData.setId(0);
        userDaoImpl.save(userData);
        return userData;
    }

// Meant for Troubleshooting ONLY!
//    @DeleteMapping("/delete/")
//    public void deleteAllUsers() {
//        userDaoImpl.deleteAllUsers();
//    }

    @DeleteMapping("/delete/id={id}")
    public void delete(@PathVariable int id) {
        userDaoImpl.delete(id);
    }

    @GetMapping("/")
    public List<UserData> getUsers() {
        return userDaoImpl.getAllUsers();
    };

    @GetMapping("/afm={afm}")
    public UserData get(@PathVariable int afm) {
        return userDaoImpl.findUserByAFM(afm);
    }
}
