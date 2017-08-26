package com.shop.service;

import com.shop.dao.PromotiomDao;
import com.shop.model.Promotion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14999 on 2017/8/26.
 */
@Service
public class PromotionService {
    @Resource
    private PromotiomDao promotiomDao;
    public List<Promotion> findProductCategoryPromotions(Integer productCategoryId, Integer limit) {
        return promotiomDao.findProductCategoryPromotions(productCategoryId,limit);
    }
}
