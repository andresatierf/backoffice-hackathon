package org.academiadecodigo.bootcamp65.controller;

import org.academiadecodigo.bootcamp65.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

public class AuthController {

    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/api/")
    public void authenticate(int id){
        if(userService.get(id) != null){
            //success
        }else{
            System.out.println("");
        }
    }
}
