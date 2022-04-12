package com.example.controller;

import com.example.bean.Cate;
import com.example.bean.Supplier;
import com.example.service.CateService;
import com.example.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private CateService cateService;

    @Autowired
    private SupplierService supplierService;

    @ResponseBody           //返回json数据
    @GetMapping("/cate")
    public Cate getCate(@RequestParam(name = "id",required = false)  String id){
        return cateService.getCate(id);
    }

    @ResponseBody
    @GetMapping("supplier")
    public Supplier getSupplierById(@RequestParam(name = "id",required = false) String id){
        return supplierService.getSupplierById(id);
    }



}
