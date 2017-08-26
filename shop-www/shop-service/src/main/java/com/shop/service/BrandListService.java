package com.shop.service;

import com.shop.dao.BrandListDao;
import com.shop.model.Brand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14999 on 2017/8/25.
 */
@Service
public class BrandListService {
    @Resource
    private BrandListDao brandListDao;
    public List<Brand> findProductCategoryBrands (Integer productCategoryId,Integer limit){
        return brandListDao.findProductCategoryBrands(productCategoryId,limit);

    }
}
