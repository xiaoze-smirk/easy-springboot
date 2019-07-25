package com.xiaoze.course.controller;

import java.util.Map;

import com.xiaoze.course.annotation.CurrentUser;
import com.xiaoze.course.entity.UserInfo;
import com.xiaoze.course.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @ResponseBody
    @PostMapping(value="/login")
    public Boolean login(@RequestBody User user, Map<String, Object> map,
                         @CurrentUser UserInfo userInfo){

        //userInfo是用户登录信息
        log.info(userInfo.toString());

        if(userService.getById(user.getUserNo()) != null){
            User user1=userService.getById(user.getUserNo());
            if(user1.getUserPwd().equals(user.getUserPwd())){
                map.put("user",user1);
                return true;
            }
        }

        return false;
    }

    @GetMapping("/mainController/{userNo}")
    public String main(@PathVariable String userNo, Map<String, Object> map){
        map.put("user",userService.getById(userNo));
        return "main";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:/security/toLogin";

    }

}