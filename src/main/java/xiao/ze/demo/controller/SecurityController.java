package xiao.ze.demo.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import xiao.ze.demo.entity.User;
import xiao.ze.demo.service.UserService;

/**
 * Created by xiaozemaliya on 2017/1/31.
 */
@Controller
@RequestMapping("/security")
public class SecurityController extends BaseController{

    @Autowired
    private UserService userService ;

    @RequestMapping("/index")
    public String root() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin(Map<String, Object> map) {

        map.put("user", new User());

        return "login";
    }


    @PostMapping(value="/login")
    public String login(User user,Map<String, Object> map){

        if(userService.get(user.getUserNo())!=null){
            User user1=userService.get(user.getUserNo());
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