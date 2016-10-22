package com.xph.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huipei.x on 2016/10/17 0017.
 */
@Controller
public class UserController {

    @RequestMapping("/createview")
    public String view(){
        return "/view";
    }
}
