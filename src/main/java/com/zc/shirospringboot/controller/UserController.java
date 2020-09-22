package com.zc.shirospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    /**
      * @Author: zcct on 2020/9/21 17:02
      * @param:  
      * @return: 
      * @Description:
      */

    @RequestMapping("login")
    public String login(String username,String password)

    {
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        try {
            subject.login(usernamePasswordToken);
            return "redirect:/index.jsp";

        } catch (UnknownAccountException e) {
            log.info("用户名错误");
        }
        catch (IncorrectCredentialsException e) {
            log.info("密码错误");
        }
        return "login";
    }
}
