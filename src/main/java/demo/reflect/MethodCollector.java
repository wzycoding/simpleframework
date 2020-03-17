package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodCollector {
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        Class clazz = ReflectTarget.class;
        Constructor noArgsConstructor = clazz.getConstructor();
        ReflectTarget reflectTarget = (ReflectTarget) noArgsConstructor.newInstance();
        /** getDeclaredMethods 获取的是类中的所有方法，包含私有、default、protect **/
        Method [] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("[" + declaredMethod.getName() + "]");
        }
        Method show1 = clazz.getDeclaredMethod("show1", String.class);
        Method show2 = clazz.getDeclaredMethod("show2", String.class);
        Method show3 = clazz.getDeclaredMethod("show3", int.class);
        Method show4 = clazz.getDeclaredMethod("show4", int.class, String.class);
        show4.setAccessible(true);
        show1.invoke(reflectTarget, "我爱你");
        show2.invoke(reflectTarget, "在一起");
        show3.invoke(reflectTarget, 1);
        show4.invoke(reflectTarget, 122, "武汉加油");

        System.out.println("===========getMethods===============");
        /** getMethods 获取的当前类中和父类中的所有public方法对象**/
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
