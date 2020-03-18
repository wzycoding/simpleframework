package demo.parttern.singleton;

/**
 * 饿汉单例模式
 */
public class StarvingSingleton {
    public static final StarvingSingleton starvingSingleton = new StarvingSingleton();

    private StarvingSingleton() {

    }

    public static StarvingSingleton getInstance() {
        return starvingSingleton;
    }

    public static void main(String[] args) {
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());
    }

}
