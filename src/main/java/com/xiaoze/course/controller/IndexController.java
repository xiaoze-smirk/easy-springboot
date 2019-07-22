package com.xiaoze.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

}
