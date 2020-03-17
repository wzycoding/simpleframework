package demo.parttern.factory.abstractf;

import demo.parttern.factory.entity.Keyboard;
import demo.parttern.factory.entity.Mouse;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new DellComputerFactory();
        Mouse mouse = computerFactory.createMouse();
        Keyboard keyboard = computerFactory.createKeyboard();

        mouse.sayHi();
        keyboard.sayHello();

    }
}
