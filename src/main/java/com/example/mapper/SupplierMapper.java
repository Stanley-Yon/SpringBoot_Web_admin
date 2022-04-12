package com.example.mapper;

import com.example.bean.Supplier;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SupplierMapper {
    /**
     * 简单的SQL语句使用注解，从而避免大量配置xml文件
     * 复杂的使用XML文件
     */
    @Select("select * from supplier where supplierId=#{id}")
    public Supplier getSupplierById(String id);

//    @Insert("insert into supplier() value() ")
//    public InsertSupplier();

}
