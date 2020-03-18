package demo.parttern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumStarvingSingleton {
    private EnumStarvingSingleton() {

    }

    public static EnumStarvingSingleton getInstance() {
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder{
        HOLDER;
        private EnumStarvingSingleton instance;
        //枚举构造方法本来就是私有的
        private ContainerHolder() {
            //枚举启动的时候就会创建，所以说明也是饿汉模式
            instance = new EnumStarvingSingleton();
        }

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = ContainerHolder.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());
        System.out.println(ContainerHolder.HOLDER.instance);
    }


}
