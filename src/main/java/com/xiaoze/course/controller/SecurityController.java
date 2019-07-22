package com.xiaoze.course.controller;

import java.util.Map;

import com.xiaoze.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.xiaoze.course.entity.User;

/**
 * SecurityController
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserService userService ;

    /**
     * 进入首页
     * @return String
     */
    @GetMapping("/index")
    public String root() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin(Map<String, Object> map) {

        map.put("user", new User());

        return "login";
    }


    @PostMapping(value="/login")
    public String login(User user, Map<String, Object> map){

        if(userService.getById(user.getUserNo()) != null){
            User user1=userService.getById(user.getUserNo());
            if(user1.getUserPwd().equals(user.getUserPwd())){
                map.put("user",user1);
                return "main";
            }
        }


        return "login";
    }

    @GetMapping("/mainController")
    public String main(){

        return "main";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:/security/toLogin";

    }

}