package demo.parttern.factory.abstractf;

import demo.parttern.factory.entity.Keyboard;
import demo.parttern.factory.entity.Mouse;

public interface ComputerFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}
