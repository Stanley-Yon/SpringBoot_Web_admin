package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.User;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class tableController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam( name = "param" ,required = false) String param){

      //  int res=10/0;   //出错跳转error下的5xx.html页面

        return "/table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam(value = "pn" ,defaultValue = "1") Integer pn) {
//        List<User> users = Arrays.asList(new User("zhangsan", "132341"),
//                new User("lisi", "wadawdwad"),
//                new User("xiaohong", "dadwad"),
//                new User("xiaoming", "wadawdad"),
//                new User("龙哥", "123456"));
//        model.addAttribute("users",users);

        List<User> list = userService.list();

        //构造分页参数
        Page<User> page = new Page<>(pn, 2);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);

        long current = userPage.getCurrent();
        long total = userPage.getTotal();
        long pages = userPage.getPages();

        List<User> records = userPage.getRecords(); //真正的所有数据

        model.addAttribute("users", userPage);

        return "/table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/editable_table")
    public String editable_table(){
        return "/table/editable_table";
    }
    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "/table/pricing_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "/table/responsive_table";
    }


}
