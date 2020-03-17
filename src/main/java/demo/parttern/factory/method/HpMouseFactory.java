package demo.parttern.factory.method;

import demo.parttern.factory.entity.HpMouse;
import demo.parttern.factory.entity.Mouse;

public class HpMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
