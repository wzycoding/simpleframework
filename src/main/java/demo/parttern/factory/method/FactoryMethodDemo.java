package demo.parttern.factory.method;

import demo.parttern.factory.entity.Mouse;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        MouseFactory mf = new HpMouseFactory();
        Mouse mouse = mf.createMouse();
        mouse.sayHi();
    }
}
