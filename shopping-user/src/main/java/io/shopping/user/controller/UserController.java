package io.shopping.user.controller;

import io.shopping.common.response.ServerResponse;
import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.service.UserBaseService;
import io.shopping.user.vo.UserLoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wilson
 * @date 2019/9/24
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserBaseService userBaseService;

    @PostMapping("/register")
    public ServerResponse<Integer> register(@RequestBody UserBase userBase) {
        return ServerResponse.success(userBaseService.insert(userBase));
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerResponse login(@Validated @RequestBody UserLoginVO vo, HttpServletResponse response) {
        return userBaseService.login(vo, response);
    }
}
