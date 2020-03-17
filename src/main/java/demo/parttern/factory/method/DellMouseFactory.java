package demo.parttern.factory.method;

import demo.parttern.factory.entity.DellMouse;
import demo.parttern.factory.entity.Mouse;

public class DellMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
