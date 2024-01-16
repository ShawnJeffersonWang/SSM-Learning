package com.shawn.controller;

import com.shawn.pojo.Address;
import com.shawn.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试响应数据
 */
@RestController
public class ResponseController {
//
//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("hello world");
//        return "hello world";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr() {
//        Address addr = new Address();
//        addr.setProvince("California");
//        addr.setCity("MountainView");
//        return addr;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr() {
//        List<Address> list = new ArrayList<>();
//
//        Address addr = new Address();
//        addr.setProvince("California");
//        addr.setCity("MountainView");
//
//        Address addr2 = new Address();
//        addr2.setProvince("Georgia");
//        addr2.setCity("Atlanta");
//
//        list.add(addr);
//        list.add(addr2);
//        return list;
//    }

    // 统一响应结果Result(code, msg, data), 响应给前端的数据格式只有一种
    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("hello world");
//        return new Result(1, "success", "hello world");
        return Result.success("hello world");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("California");
        addr.setCity("MountainView");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("California");
        addr.setCity("MountainView");

        Address addr2 = new Address();
        addr2.setProvince("Georgia");
        addr2.setCity("Atlanta");

        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }
}
