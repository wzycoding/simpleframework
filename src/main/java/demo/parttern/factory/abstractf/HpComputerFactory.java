package demo.parttern.factory.abstractf;

import demo.parttern.factory.entity.HpKeyboard;
import demo.parttern.factory.entity.HpMouse;
import demo.parttern.factory.entity.Keyboard;
import demo.parttern.factory.entity.Mouse;

public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
