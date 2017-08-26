package com.shop.service;

import com.shop.dao.ProductCategoryDao;
import com.shop.model.ProductCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14999 on 2017/8/25.
 */
@Service
public class ProductCategoryRootListService {

    @Resource
    private ProductCategoryDao productCategoryDao;

    public List<ProductCategory> findRootList() {
        return productCategoryDao.findRootList();

    }
}
