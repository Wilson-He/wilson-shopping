package io.shopping.test.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Wilson
 * @date 2019/9/23
 **/
@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name",name);
        return "hello";
    }
}
