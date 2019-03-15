package com.itheima.core.service.brand;

import com.itheima.core.pojo.good.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有手机品牌
     */
    List<Brand> findAll();
}
