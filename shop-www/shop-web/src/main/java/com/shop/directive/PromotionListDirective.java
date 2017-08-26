package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.constant.Constant;
import com.shop.model.Promotion;
import com.shop.service.PromotionService;
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
 * Created by 14999 on 2017/8/26.
 */
@Component
public class PromotionListDirective implements TemplateDirectiveModel {
    @Resource
    private PromotionService promotionService;
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel positionTm = (TemplateModel)params.get("productCategoryId");
        Integer productCategoryId = (Integer)beansWrapper.unwrap(positionTm, Integer.class);
        positionTm = (TemplateModel)params.get("count");
        Integer limit = (Integer)beansWrapper.unwrap(positionTm, Integer.class);
        if(limit == null){
            limit = Constant.SIX;
        }
        List<Promotion> promotions = promotionService.findProductCategoryPromotions(productCategoryId, limit);
        TemplateModel templateModel = beansWrapper.wrap(promotions);
        env.setVariable("promotions", templateModel);
        // 输出
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(promotions));
        }
    }
}
