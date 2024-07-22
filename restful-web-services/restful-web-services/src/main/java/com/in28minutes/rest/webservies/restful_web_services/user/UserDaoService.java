//DAO  data access object here it is UserDAOService//node js main ye service hain
//based on the schema of incoming data functions are derived in service which will be used in controller.
//model of data(module or interface or class) is imported in service and then service is imported in controller.
//service will have DAO functions, data accessing functions, controller will have means to call the service hence controller is not DAO.
package com.in28minutes.rest.webservies.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //JPA/Hibernate > Database
    //UserDaoService > Static List

    //list type defined as User and named as users which is storing instances of ArrayList()
    private static List<User> users = new ArrayList<>();//declared only here and hence empty

    private static int usersCount = 0;

    //this is a static list.
    static {
        //users.add(new User(1,"Adam", LocalDate.now().minusYears(30))); //this is the format intellij adds variable to show without altering the program to help developers to understand
        //users.add(new User(2,"Eve", LocalDate.now().minusYears(25)));
        //users.add(new User(3,"Jim", LocalDate.now().minusYears(20)));//this is hardcoding.

        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"Jim", LocalDate.now().minusYears(20)));
    }

    //private static int usersCount = 3;//this is hard coding hence instead we will take it as 0 and then will increment

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);//assigning ID to new users dynamically
        users.add(user);
        return user;
    }

    //we are finding here user hence we have provided it return type of User class
    public User findOne(int id) {
        //predicate variable is having predicate type (it is a function whose type here we have defined as constructor of User class) passed with user as argument and then in body
        //we are comparing the incoming user if with the id passed of findOne function
        Predicate<?super User> predicate = user -> user.getId().equals(id);
        //if incoming id is equal to predicate then convert the value in stream
        //and filter according to predicate function variable and then fetch.
        return users.stream().filter(predicate).findFirst().orElse(null);
        //if get will be there in place of orElse then it will either fetch or throw no such element exception
    }

    //we just want to delete hence we do not need to give type and hence void is our return type.
    //DAO is having delete method ready now when we receive instructions to delete we will use this function in our controller.
    public void deleteById(int id) {
        //match by id logic
        Predicate<?super User> predicate = user -> user.getId().equals(id);
        //if it matches remove the user
        users.removeIf(predicate);
    }

}
