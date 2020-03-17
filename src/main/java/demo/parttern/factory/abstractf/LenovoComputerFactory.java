package demo.parttern.factory.abstractf;

import demo.parttern.factory.entity.Keyboard;
import demo.parttern.factory.entity.LenovoKeyboard;
import demo.parttern.factory.entity.LenovoMouse;
import demo.parttern.factory.entity.Mouse;

public class LenovoComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new LenovoKeyboard();
    }
}
