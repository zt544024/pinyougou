package com.itheima.core.service.brand;

import com.itheima.core.entity.PageResult;
import com.itheima.core.pojo.good.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有手机品牌
     */
    List<Brand> findAll();

    /**
     * 无条件分页查询
     */
    PageResult findPage(Integer pageNum,Integer pageSize);

    /**
     * 有条件查询
     */
    PageResult search(Integer pageNum,Integer pageSize,Brand brand);

    /**
     * 添加品牌
     */
    void add(Brand brand);
}
