package gr.hua.dit.ds.Katanemimena_Ergasia.Controllers;

import gr.hua.dit.ds.Katanemimena_Ergasia.DAO.User_DAO_Impl;
import gr.hua.dit.ds.Katanemimena_Ergasia.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class User_Controller {

    @Autowired
    private User_DAO_Impl userDaoImpl;

    @GetMapping("/")
    public List<User> getUsers() {
        return userDaoImpl.getAllUsers();
    };
}
