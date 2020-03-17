package demo.parttern.factory.method;

import demo.parttern.factory.entity.IBMMouse;
import demo.parttern.factory.entity.Mouse;

public class IBMMouseFactory extends LenovoMouseFactory {
    @Override
    public Mouse createMouse() {
        return new IBMMouse();
    }
}
