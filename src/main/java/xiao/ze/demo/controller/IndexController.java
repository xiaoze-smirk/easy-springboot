package xiao.ze.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiaoze
 * @date 2018/5/29
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

}
