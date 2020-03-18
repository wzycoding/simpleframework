package org.simpleframework.core;

import com.imooc.controller.DispatcherServlet;
import com.imooc.controller.frontend.MainPageController;
import com.imooc.service.solo.HeadLineService;
import com.imooc.service.solo.impl.HeadLineServiceImpl;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {
    private static BeanContainer beanContainer;

    /**
     * @BeforeAll启动时初始化一次
     */
    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @Test
    @Order(1)
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.imooc");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

    @DisplayName("根据类获取其实例：getBeanTest")
    @Test
    @Order(2)
    public void getBean() {
        MainPageController controller = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, controller instanceof MainPageController);
        DispatcherServlet dispatcherServlet = (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        Assertions.assertEquals(null, dispatcherServlet);
    }

    @DisplayName("根据注解获取对应的实例：getClassesByAnnotationTest")
    @Order(3)
    @Test
    public void getClassesByAnnotationTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(3, beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @Test
    @Order(4)
    public void getClassesBySuperTest() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(true, beanContainer.getClassesBySuper(HeadLineService.class).contains(HeadLineServiceImpl.class));
    }

}
