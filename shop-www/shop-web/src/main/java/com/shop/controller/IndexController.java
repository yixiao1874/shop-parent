package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by TW on 2017/8/22.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping("test")
    public String test(Model model) {

        model.addAttribute("realName", null);
        model.addAttribute("userId", 1000000);
        model.addAttribute("isMan", true);
        model.addAttribute("createDate", new Date());

       return "test";
    }

    @RequestMapping("hello")
    public String hello(Model model) {
        return "hello";
    }

    @RequestMapping("index")
    public String index(Model model) {
        return "index";
    }

}
