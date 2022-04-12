package com.example.service;

import com.example.bean.Cate;
import com.example.mapper.CateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateService {
    @Autowired
    private CateMapper cateMapper;

    public Cate getCate(String id){
        return cateMapper.getCate(id);
    }
}
