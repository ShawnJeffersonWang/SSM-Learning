package com.shawn.controller;

import com.shawn.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 测试请求参数接收
 */
/*
 * @ResponseBody
 * 类型：方法注解，类注解
 * 位置：Controller方法上、类上
 * 作用：将方法返回值直接响应，如果返回值类型是 实体对象、集合，将会转换为JSON数据响应
 * 说明：@RestController=@Controller+@ResponseBody
 *
 * 元注解：修饰注解的注解
 */
@RestController
//@Controller
//@ResponseBody
public class RequestController {

    // 原始方式
    // Controller方法形参中声明HttpServletRequest对象
    // 调用对象的getParameter(参数名)
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        // 获取请求参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        int age = Integer.parseInt(ageStr);
        System.out.println(name + ":" + age);
        return "OK";
    }

    // springboot方式
    // 简单参数：参数名与形参变量名相同，定义形参即可接受参数
    // 会自动进行类型转换
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name, Integer age) {
//        System.out.println(name + ":" + age);
//        return "OK";
//    }

    // @RequestParam方法形参名称与请求参数不匹配，通过该注解完成映射
    // @RequestParam中的required属性默认为true，代表该请求参数必须传递，如果不传递将报错
    // 如果该参数是可选的，可以将required属性设置为false
    // 如果方法形参名称与请求参数名称不匹配，可以使用@RequestParam完成映射
//    @RequestMapping("/simpleParam")
//    public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age) {
//        System.out.println(username + ":" + age);
//        return "OK";
//    }
//
//    // 2.实体参数
//    // 简单实体对象：请求参数名与形参对象属性名相同，定义POJO接受即可
//    @RequestMapping("/simplePojo")
//    public String simplePojo(User user) {
//        System.out.println(user);
//        return "OK";
//    }
//
//    // 3.复杂参数
//    // 复杂实体对象：请求参数名与形参对象属性名相同，按照对象层次结构关系即可接收嵌套POJO属性参数
//    @RequestMapping("/complexPojo")
//    public String complexPojo(User user) {
//        System.out.println(user);
//        return "OK";
//    }
//
//    // 数组集合参数
//    // 请求参数名与形参数组名称相同且请求参数为多个，定义数组类型即可接受参数
//    @RequestMapping("/arrayParam")
//    public String arrayParam(String[] hobby) {
//        System.out.println(Arrays.toString(hobby));
//        return "OK";
//    }
//
//    // 集合参数
//    // 请求参数名与形参集合名称相同且请求参数为多个，@RequestParam绑定参数关系
//    @RequestMapping("/listParam")
//    public String listParam(@RequestParam List<String> hobby) {
//        System.out.println(hobby);
//        return "OK";
//    }
//
//    // 4.日期时间参数
//    // bug时间格式必须和pattern完全一致
//    @RequestMapping("/dateParam")
//    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
//        System.out.println(updateTime);
//        return "OK";
//    }
//
//    // 5. JSON参数：JSON数据键名与形参对象属性名相同，定义POJO类型形参即可接受参数，需要使用@RequestBody标识
//    @RequestMapping("/jsonParam")
//    public String jsonParam(@RequestBody User user) {
//        System.out.println(user);
//        return "OK";
//    }
//
//    // 路径参数：通过请求URL直接传递参数，使用{...}来表示路径参数，需要使用@PathVariable获取路径参数
//    @RequestMapping("/path/{id}")
//    public String pathParam(@PathVariable Integer id) {
//        System.out.println(id);
//        return "OK";
//    }
//
//    // 获取到路径参数，并将其绑定到方法的形参
//    @RequestMapping("/path/{id}/{name}")
//    public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
//        System.out.println(id + ":" + name);
//        return "OK";
//    }
}
