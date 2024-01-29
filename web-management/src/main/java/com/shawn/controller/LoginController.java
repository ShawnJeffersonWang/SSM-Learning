package com.shawn.controller;

import com.shawn.pojo.Emp;
import com.shawn.pojo.Result;
import com.shawn.service.EmpService;
import com.shawn.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
登录标记：用户登录成功之后，每一次请求中，都可以获取到该标记（会话技术）

会话技术：
会话：用户打开浏览器，访问web服务器的资源，会话建立，直到有一方断开连接，会话结束。在一次会话中可以包含多次请求和响应
会话跟踪：一种维护浏览器状态的方法，服务器需要识别多次请求是否来自同一浏览器，以便在同一次会话的请求间共享数据

方案一：Cookie 优点：HTTP协议中支持的技术
响应头：Set-Cookie: name=value
请求头：Cookie: name=value

会话跟踪方案：
客户端会话跟踪技术：Cookie
服务端会话跟踪技术：Session
令牌技术

统一拦截：
1. 过滤器Filter
2. 拦截器Interceptor
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录: {}", emp);
        Emp e = empService.login(emp);
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            // jwt包含了当前登录的员工信息
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        // 登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }

}
