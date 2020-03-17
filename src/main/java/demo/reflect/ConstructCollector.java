package demo.reflect;

import java.lang.reflect.Constructor;

public class ConstructCollector {
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        Class clazz = ReflectTarget.class;

        //getDeclaredConstructors()方法可以获取所有权限构造方法，并不会获取父类的构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println(declaredConstructors.length);


        //只获取public的构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println(constructors.length);

        Constructor noArgsConstructor = clazz.getConstructor();
        Constructor protectedConstructor = clazz.getDeclaredConstructor(int.class);
        Constructor defaultConstructor = clazz.getDeclaredConstructor(char.class);
        Constructor privateConstructor = clazz.getDeclaredConstructor(String.class);
        //访问private的构造方法需要设置setAccessible为true
        privateConstructor.setAccessible(true);


        ReflectTarget target1 = (ReflectTarget) noArgsConstructor.newInstance();
        ReflectTarget target2 = (ReflectTarget) protectedConstructor.newInstance(1);
        ReflectTarget target3 = (ReflectTarget) defaultConstructor.newInstance('a');
        ReflectTarget target4 = (ReflectTarget) privateConstructor.newInstance("当你凝望深渊时，深渊同样凝望着你");
        System.out.println(target1.hashCode());
        System.out.println(target2.hashCode());
        System.out.println(target3.hashCode());
        System.out.println(target4.hashCode());
    }
}
