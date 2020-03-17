package demo.parttern.factory.abstractf;

import demo.parttern.factory.entity.DellKeyboard;
import demo.parttern.factory.entity.DellMouse;
import demo.parttern.factory.entity.Keyboard;
import demo.parttern.factory.entity.Mouse;

public class DellComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
