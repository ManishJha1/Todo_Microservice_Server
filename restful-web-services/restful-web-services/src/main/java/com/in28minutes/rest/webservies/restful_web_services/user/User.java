//this is my User BIN//node js main ye interface and model hain
//this gives my data a structure hence it defines the schema
//in Java they are called BIN. Service is called DAO
package com.in28minutes.rest.webservies.restful_web_services.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;//import in eclipse ctrl+shift+o and in intellij Alt+shift+ent

public class User {
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")//validation provided for size of name
    private String name;

    @Past(message = "Birth Date should be in the past")//validation added so that birth date cannot be in future and present.
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate){
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }
}
