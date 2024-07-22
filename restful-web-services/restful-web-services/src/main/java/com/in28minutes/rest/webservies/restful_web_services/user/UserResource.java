package com.in28minutes.rest.webservies.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //Get/users_specific    in java{} this is used to take value for a given variable if in path then it is path variable //this is our retrieve user method
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id:"+id);

        return user;
    }

    //delete/users_specific    in java{} this is used to delete value for a given variable(here it is ID) if in path then it is path variable //this is our delete user method which will delete
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        //using service function to delete the object whose return type is void hence is not getting stored in any variable
        service.deleteById(id);
        //if it is successful you will get 200 response.
    }

    //Post/users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        //spring boot provided the http status hence we have to use the accurate function over which httpresponse will be updated.
        //return ResponseEntity.created(null).build(); it will just add as location is null but if we need to know what has been added as uri then
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//adding path
                .buildAndExpand(savedUser.getId())//taken the coming ID
                .toUri();//converted into URI
        return ResponseEntity.created(location).build();
    }
}
