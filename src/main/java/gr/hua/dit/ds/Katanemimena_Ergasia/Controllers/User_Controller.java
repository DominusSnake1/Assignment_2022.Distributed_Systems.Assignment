package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.User_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class User_Controller {

    @Autowired
    private User_DAO_Impl userDaoImpl;

    @PostMapping("/")
    public User save(@RequestBody User user) {
        user.setId(0);
        userDaoImpl.save(user);
        return user;
    }

    @DeleteMapping("/delete/")
    public void deleteAllUsers() {
        userDaoImpl.deleteAllUsers();
    }

    @DeleteMapping("/delete/id={id}")
    public void delete(@PathVariable int id) {
        userDaoImpl.delete(id);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userDaoImpl.getAllUsers();
    };

    @GetMapping("/id={id}")
    public User get(@PathVariable int id) {
        return userDaoImpl.findUserById(id);
    }
}
