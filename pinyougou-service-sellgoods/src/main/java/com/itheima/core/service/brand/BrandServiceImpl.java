package com.itheima.core.service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.core.dao.good.BrandDao;
import com.itheima.core.pojo.good.Brand;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    @Override
    public List<Brand> findAll() {
        return brandDao.selectByExample(null);
    }
}
