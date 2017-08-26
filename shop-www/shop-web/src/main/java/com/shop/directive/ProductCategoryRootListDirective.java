package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.model.ProductCategory;
import com.shop.service.ProductCategoryRootListService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by 14999 on 2017/8/25.
 */
@Component
public class ProductCategoryRootListDirective implements TemplateDirectiveModel{

    @Autowired
    private ProductCategoryRootListService productCategoryRootListService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        //获取数据
        List<ProductCategory> productCategories = productCategoryRootListService.findRootList();
        //输出数据
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel templateModel = beansWrapper.wrap(productCategories);
        env.setVariable("productCategories", templateModel);
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(productCategories));
        }
    }
}
