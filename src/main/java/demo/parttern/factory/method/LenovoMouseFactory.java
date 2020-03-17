package demo.parttern.factory.method;

import demo.parttern.factory.entity.LenovoMouse;
import demo.parttern.factory.entity.Mouse;

public class LenovoMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}
