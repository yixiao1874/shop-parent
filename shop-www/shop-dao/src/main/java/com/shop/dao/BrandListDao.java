package com.shop.dao;

import com.shop.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 14999 on 2017/8/25.
 */
@Repository
public interface BrandListDao {
    @Select("SELECT id,`name` FROM xx_brand t1 LEFT JOIN xx_product_category_brand t2 " +
            " on t1.id = t2.brands where t2.product_categories = #{productCategoryId} " +
            " ORDER BY orders LIMIT #{limit}")
    List<Brand> findProductCategoryBrands(@Param(value = "productCategoryId") Integer productCategoryId,
                                          @Param(value = "limit") Integer limit);
}
