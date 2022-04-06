package com.example.controller;

import com.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {
    /**
     * 来登录页面
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 重定向转main页面，避免页面form的重复提交
     * @param user
     * @return
     */
    @PostMapping(value = "login")
    public String mainPage(User user, Model model,HttpSession session) {
        if (StringUtils.hasLength(user.getUsername()) && user.getPassword().equals("123")) {
            session.setAttribute("loginUser",user);
            return "redirect:main";
        }else {
            model.addAttribute("msg","登录出错");
            return "login";
        }
    }

    @GetMapping("main")
    public String main(HttpSession session,Model model){
        // 最好用拦截器,过滤器
        Object loginUser=session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else {
            model.addAttribute("msg","未登录");
            return "login";
        }

    }




}
