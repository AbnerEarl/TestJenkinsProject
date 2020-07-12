package com.ycj.phonenumber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2020/5/14
 * @time: 7:48
 * @fuction: about the role of class.
 */

@Controller
public class WebPage {

    @RequestMapping("/location")
    public String location(){
        return "location";
    }
    @RequestMapping("/baidu")
    public String baidu(){
        return "baidu";
    }

    @RequestMapping("/getnumber")
    public String getnumber(){
        return "getnumber";
    }

    @RequestMapping("/getdata")
    public String getdata(){
        return "getdata";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/getphone")
    public String getphone(){
        return "getphone";
    }

    @RequestMapping("/myphone")
    public String myphone(){
        return "myphone";
    }

    @RequestMapping("/detect")
    public String detect(HttpServletRequest request){
        // WAP网页取得用户的手机号码
// 如果通信运营商给送的话，一般在Http请求头的x-up-calling-line-id项里
        String mobile = request.getHeader("x-up-calling-line-id");   // GPRS
        System.out.println(mobile);
        if (mobile == null) {
            mobile = request.getHeader("x-up-subno");   // CDMA
            System.out.println(mobile);

        }
        if (mobile == null) {
            mobile = request.getHeader("x-network-info");
            System.out.println(mobile);

        }
        if (mobile == null) {
            mobile = request.getHeader("deviceid");
            System.out.println(mobile);

        }
        if (mobile == null) {
            // 有些wap门户站点跳转过来，手机号码由参数mobile传递过来
            mobile = request.getParameter("mobile");
            System.out.println(mobile);

        }
        if (mobile != null) {
            // 某些情况下，手机号码前面会加上中国国际区号86，需要去掉
            if (mobile.length() == 13 && mobile.startsWith("86")) {
                mobile = mobile.substring(2);
                System.out.println(mobile);

            }
            // TODO: 现在，程序可以认为用户身份(手机号码)已经确认，免登录(手机上输入账号密码不太容易)
            System.out.println(mobile);

        } else {
            // TODO: 无法取得手机号码的情况
            System.out.println("获取失败");

        }
        return "detect";
    }
}
