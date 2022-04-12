package com.example.service;

import com.example.bean.Supplier;
import com.example.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    public Supplier getSupplierById(String id){
        return supplierMapper.getSupplierById(id);
    }



}
