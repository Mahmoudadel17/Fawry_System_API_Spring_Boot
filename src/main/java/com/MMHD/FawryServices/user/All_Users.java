package com.MMHD.FawryServices.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Objects;
@Service
public class All_Users {
    private  static final LinkedList<User> Alluser = new LinkedList<>();

    public  LinkedList<User> getAlluser() {
        return Alluser;
    }

    public  User Search_About_User(String email){
        for (User user : Alluser) {
            if (Objects.equals(email, user.getEmail())) {
                return user;
            }
        }
        return null;
    }
    public  User Search_About_UserID(int id){
        for (User user : Alluser) {
            if (Objects.equals(id, user.getId())) {
                return user;
            }
        }
        return null;
    }
    public int getSize(){
        return Alluser.size();
    }

    public  void Add_user(User NewUser) {
        Alluser.add(NewUser);

    }



}