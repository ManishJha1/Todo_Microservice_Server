package com.in28minutes.rest.webservies.restful_web_services.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserResource {
//importing userDaoService and store it in a variable but using private keyword to make it use in this program only.
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    //Get/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //Get/users_specific    in java{} this is used to take value for a given variable if in path then it is path variable
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }
}
