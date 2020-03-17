package demo.parttern.factory.simple;

import demo.parttern.factory.entity.DellMouse;
import demo.parttern.factory.entity.HpMouse;
import demo.parttern.factory.entity.Mouse;

/**
 * 简单工厂模式：隐藏了对象创建的细节，客户端不需要创建实例，只需要告诉工厂需要什么样的鼠标即可
 */
public class MouseFactory {
    public static Mouse createMouse(int type) {
        switch (type) {
            case 0: return new DellMouse();
            case 1: return new HpMouse();
            default:return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse hpMouse = MouseFactory.createMouse(1);
        Mouse dellMouse = MouseFactory.createMouse(0);
        hpMouse.sayHi();
        dellMouse.sayHi();
    }
}
