package demo.parttern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        System.out.println(StarvingSingleton.getInstance());
//        System.out.println(StarvingSingleton.getInstance());
//        System.out.println(LazyDoubleCheckSingleton.getInstance());
//        System.out.println(LazyDoubleCheckSingleton.getInstance());
//        Class clazz = StarvingSingleton.class;
////        Constructor constructor = clazz.getDeclaredConstructor();
////        constructor.setAccessible(true);
////        StarvingSingleton starvingSingleton = (StarvingSingleton) constructor.newInstance();
////        System.out.println(starvingSingleton);
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz1 = EnumStarvingSingleton.class;
        Constructor declaredConstructor = clazz1.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton) declaredConstructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());
    }
}
