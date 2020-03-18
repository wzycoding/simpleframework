package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class BeanContainer {
    //CAS+红黑树
    /**
     * 键：Class,值：容器的实例
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Component.class, Service.class, Repository.class, Controller.class);
    /**
     * 获取ioc容器的实例
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;
        private ContainerHolder() {
            instance = new BeanContainer();
        }
    }
    /**
     * 容器是否已经加载过bean
     */
    private boolean loaded = false;

    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 扫描加载所有bean
     * @param packageName
     */
    public synchronized void loadBeans(String packageName) {
        //判断bean容器是否被加载过
        if (loaded) {
            log.warn("BeanContainer has been loaded");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (classSet == null || classSet.isEmpty()) {
            log.warn("extract noting from packageName" + packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                //如果类上面标记了定义的注解
                if (clazz.isAnnotationPresent(annotation)) {
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * Bean实例数量
     * @return
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 添加一个Class对象及其Bean实例
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    /**
     * 移除一个IOC容器管理的对象
     */
    public Object removeBean(Class<?> clazz){
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取Bean实例
     * @param clazz bean实例
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取所有Class集合
     * @return
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }


    /**
     * 获取所有bean集合
     * @return
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }

    /**
     * 获取所有被指定注解标注的Class集合
     * @param annotation
     * @return
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        //1.获取beanMap里面所有的class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return null;
        }
        Set<Class<?>> classSet = new HashSet<>();
        //2.通过注解筛选被注解标记的Class对象，并添加到classSet里
        for (Class<?> clazz : keySet) {
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或者子类的Class集合，不包括其本身
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {
        //1.获取beanMap里面所有的class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return null;
        }
        Set<Class<?>> classSet = new HashSet<>();
        //2.接口或者父类获取实现类或者子类
        for (Class<?> clazz : keySet) {
            if (interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }
}
