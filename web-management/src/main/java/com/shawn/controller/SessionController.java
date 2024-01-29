package com.shawn.controller;

import com.shawn.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 方案一：Cookie
 * 优点：HTTP协议中支持的技术
 * 缺点：
 * 移动端APP无法使用Cookie
 * 不安全，用户可以自己禁用Cookie
 * Cookie不能跨域
 */

@Slf4j
@RestController
public class SessionController {

    // 设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        // 设置Cookie、响应Cookie
        response.addCookie(new Cookie("login_username", "shawn"));
        return Result.success();
    }

    // 获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        // 获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_username")) {
                System.out.println("login_username: " + cookie.getValue());
            }
        }
        return Result.success();
    }

    /*
    方案二：Session：
    优点：存储在服务端，安全
    缺点：1.在服务器集群环境下无法直接使用Session
         2.Cookie的缺点
     */
    // 往HttpSession中存储值
    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        log.info("HttpSession-s1: {}", session.hashCode());
        // 往session中存储数据
        session.setAttribute("loginUser", "tom");
        return Result.success();
    }

    // 从HttpSession中获取值
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());

        // 从session中获取数据
        Object loginUser = session.getAttribute("loginUser");
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }

    /*
    方案三：令牌技术：
    优点：
    支持PC端，移动端
    解决集群环境下的认证问题
    减轻服务器端存储压力
    缺点：需要自己实现
     */
}
