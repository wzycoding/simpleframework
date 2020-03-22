package org.simpleframework.inject;

import com.imooc.controller.frontend.MainPageController;
import com.imooc.service.combine.impl.HeadLineShopCategoryCombineService2;
import com.imooc.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;

public class DependencyInjectorTest {
    @Test
    @DisplayName("依赖注入doIOC")
    public void doIocTest() {
        BeanContainer beanContainer =  BeanContainer.getInstance();
        beanContainer.loadBeans("com.imooc");
        Assertions.assertEquals(true, beanContainer.isLoaded());
        MainPageController mainPageController= (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, mainPageController instanceof MainPageController);
        Assertions.assertEquals(null, mainPageController.getHeadLineShopCategoryCombineService());
        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null, mainPageController.getHeadLineShopCategoryCombineService());
        Assertions.assertEquals(true, mainPageController.getHeadLineShopCategoryCombineService() instanceof HeadLineShopCategoryCombineServiceImpl);
        Assertions.assertNotEquals(true, mainPageController.getHeadLineShopCategoryCombineService() instanceof HeadLineShopCategoryCombineService2);
    }
}
