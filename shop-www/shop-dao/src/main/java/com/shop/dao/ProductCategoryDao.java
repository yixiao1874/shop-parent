package com.shop.dao;

import com.shop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 14999 on 2017/8/25.
 */
public interface ProductCategoryDao {

    @Select("SELECT id, `name` FROM xx_product_category WHERE grade = 0 ORDER BY orders limit 6")
    List<ProductCategory> findRootList();

    @Select("SELECT id, `name` FROM xx_product_category WHERE parent = #{parentId} ORDER BY orders limit #{limit}")
    List<ProductCategory> findChilrenList(@Param(value = "parentId") Integer parentId, @Param(value = "limit") Integer limit);
}
