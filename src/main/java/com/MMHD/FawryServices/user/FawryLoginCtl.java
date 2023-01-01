package com.MMHD.FawryServices.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
public class FawryLoginCtl {
    All_Users allUsers = new All_Users();
    public static int currentUserId;

    @PostMapping (value = "/User/Login")
    public ResponseEntity<String> Login_user(@RequestBody User user) {
        if (Objects.equals(user.getEmail(), null) || Objects.equals(user.getPassword(), null)){
            return ResponseEntity.badRequest().body("invalid data");
        }
        User NewUser = allUsers.Search_About_User(user.getEmail());
        if (NewUser == null) {
             return ResponseEntity.ok("Email not found");

        } else if (Objects.equals(NewUser.getPassword(), user.getPassword())) {
            currentUserId = NewUser.getId();
           return ResponseEntity.ok("hello " + NewUser.getName()+".");

        } else {
             return ResponseEntity.ok("password incorrect--");

        }

    }

    @PostMapping(value = "/User/SignUp")
    public ResponseEntity<String> Sign_Up(@RequestBody User user) {
        if (Objects.equals(user.getName(), null)  || Objects.equals(user.getEmail(), null) || Objects.equals(user.getPassword(), null)){
            return ResponseEntity.badRequest().body("invalid data");
        }
        User check = allUsers.Search_About_User(user.getEmail());

        if (check==null){
            User newUser = new User( allUsers.getSize()+1,user.getName(),user.getEmail(),user.getPassword());
            allUsers.Add_user(newUser);
            return ResponseEntity.ok("\"Sign Up  successful\"");
        }
        else {
            return ResponseEntity.ok("\"this email already signup, Login!!\"");

        }
    }


}
