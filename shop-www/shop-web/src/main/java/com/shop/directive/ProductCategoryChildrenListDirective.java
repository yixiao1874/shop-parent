package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.constant.Constant;
import com.shop.model.ProductCategory;
import com.shop.service.ProductCategoryService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by 14999 on 2017/8/25.
 */
@Component
public class ProductCategoryChildrenListDirective implements TemplateDirectiveModel{

    @Resource
    private ProductCategoryService productCategoryService;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        //获取参数
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel positionTm = (TemplateModel)params.get("parentId");
        Integer parentId = (Integer)beansWrapper.unwrap(positionTm, Integer.class);
        positionTm = (TemplateModel)params.get("count");
        Integer limit = (Integer)beansWrapper.unwrap(positionTm, Integer.class);
        if(limit==null){
            limit= Constant.THREE;
        }
        //获取数据
        List<ProductCategory> productCategories = productCategoryService.findChilrenList(parentId, limit);
        //输出数据
        TemplateModel templateModel = beansWrapper.wrap(productCategories);
        env.setVariable("productCategories", templateModel);
        // 输出
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(productCategories));
        }
    }
}
