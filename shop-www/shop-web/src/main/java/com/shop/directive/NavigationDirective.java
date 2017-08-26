package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/8/24.
 */
@Component
public class NavigationDirective implements TemplateDirectiveModel {

    @Autowired
    private NavigationService navigationService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // BeansWrapper是一个转换器， wrap()方法将对象包装成TemplateModel, unwrap()将templateModel转化成java类
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel positionTm = (TemplateModel)params.get("position");
        Integer position = (Integer)beansWrapper.unwrap(positionTm, Integer.class);

        // 获取数据
        List<Navigation> navigationList = navigationService.findList(position);

        // BeansWrapper是一个转换器， wrap()方法将对象包装成TemplateModel, unwrap()将templateModel转化成java类
//        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        TemplateModel templateModel = beansWrapper.wrap(navigationList);
        env.setVariable("navigations", templateModel);
        // 输出
        if (body != null) {
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(navigationList));
        }


    }
}
