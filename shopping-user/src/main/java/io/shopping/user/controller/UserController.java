package io.shopping.user.controller;

import io.shopping.common.response.ResponseResult;
import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.service.UserBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Wilson
 * @date 2019/9/24
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserBaseService userBaseService;

    @PostMapping("/user")
    public ResponseResult<Integer> add(@RequestBody UserBase userBase) {
        return ResponseResult.success(userBaseService.insert(userBase));
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/layer")
    public String layer() {
        return "layer";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserBase userBase) {
        System.out.println(userBase);
        return "login";
    }
}
