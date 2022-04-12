package com.example.mapper;

import com.example.bean.Cate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CateMapper {
    public Cate getCate(String id);

}
