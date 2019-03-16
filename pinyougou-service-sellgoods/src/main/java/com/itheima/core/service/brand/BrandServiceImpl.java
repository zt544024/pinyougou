package com.itheima.core.service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.core.dao.good.BrandDao;
import com.itheima.core.entity.PageResult;
import com.itheima.core.pojo.good.Brand;
import com.itheima.core.pojo.good.BrandQuery;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Brand> page= (Page<Brand>) brandDao.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult search(Integer pageNum, Integer pageSize,Brand brand) {
        PageHelper.startPage(pageNum,pageSize);
        //设置查询条件
        BrandQuery brandQuery = new BrandQuery();
        BrandQuery.Criteria criteria = brandQuery.createCriteria();
        if(brand.getName() != null && !"".equals(brand.getName().trim())){
            criteria.andNameLike("%"+brand.getName().trim()+"%");
        }
        if(brand.getFirstChar() !=null && !"".equals(brand.getFirstChar().trim())){
            criteria.andFirstCharEqualTo(brand.getFirstChar().trim());
        }
        //根据id降序
        brandQuery.setOrderByClause(" id desc");
        Page<Brand> page= (Page<Brand>) brandDao.selectByExample(brandQuery);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Transactional
    @Override
    public void add(Brand brand) {
        brandDao.insertSelective(brand);
    }
}
