package com.itheima.core.controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.core.pojo.good.Brand;
import com.itheima.core.service.brand.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
}
