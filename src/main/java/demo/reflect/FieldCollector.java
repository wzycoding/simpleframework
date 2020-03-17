package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class FieldCollector {
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        Class clazz = ReflectTarget.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        Field[] fields = clazz.getFields();
        // getDeclaredFields()可以获取到类中，所有权限的成员变量
        for (Field declaredField : declaredFields) {
            System.out.println(" [" + declaredField.getName() + "] ");
        }
        System.out.println("================getFields()===================");
        // getFields()方法可以获取到类和其父类的public成员变量
        for (Field field : fields) {
            System.out.println(" [" + field.getName() + "] ");
        }

        Constructor constructor = clazz.getConstructor();
        ReflectTarget target = (ReflectTarget) constructor.newInstance();

        Field field1 = clazz.getDeclaredField("name");
        Field field2 = clazz.getDeclaredField("index");
        Field field3 = clazz.getDeclaredField("type");
        Field field4 = clazz.getDeclaredField("targetInfo");
        field3.setAccessible(true);

        field1.set(target, "wzy");
        field2.set(target, 1);
        field3.set(target, 'a');
        field4.set(target, "不积小流，无以成江海");

        System.out.println(target);
    }

}
