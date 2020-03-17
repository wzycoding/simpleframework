package demo.reflect;

public class ReflectTarget extends ReflectTargetOrigin {
    public String name;
    protected int index;
    private char type;
    String targetInfo;

    /** public无参构造方法 **/
    public ReflectTarget() {
        System.out.println("执行public的无参构造方法");
    }

    /** protected带参数的构造函数  **/
    protected ReflectTarget(int index) {
        System.out.println("执行protected的1个参数的构造方法" + index);
    }

    /** default带参数的构造函数**/
    ReflectTarget(char type) {
        System.out.println("执行default的1个参数的构造方法" + type);
    }

    /** private带参数的构造函数 **/
    private ReflectTarget(String targetInfo) {
        System.out.println("执行private带1个参数的构造方法" + targetInfo);
    }

    /** 成员方法 **/


    /**
     * public的普通成员方法：show1
     *
     */
    public void show1(String name) {
        System.out.println("public的普通成员方法：show1方法" + name);
    }

    /**
     * protected的普通成员方法：show2
     */
    protected void show2(String name) {
        System.out.println("protected的普通成员方法：show2" + name);
    }

    /**
     * default的普通成员方法：show3
     */
    void show3(int index) {
        System.out.println("default的普通成员方法：show3" + index);
    }

    /**
     * private的普通成员方法：show4
     */
    private void show4(int index, String name) {
        System.out.println("private的普通成员方法：show4" + index + name);
    }

    @Override
    public String toString() {
        return "ReflectTarget{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //获取class对象的三种方式
        //1.通过Class.forName()方法获取
        Class clazz1 = Class.forName("demo.reflect.ReflectTarget");
        System.out.println("1:" + clazz1.getName());

        //2.通过Object类中的getClass()方法获取
        ReflectTarget target = new ReflectTarget();
        Class clazz2 = target.getClass();
        System.out.println("2:" + clazz2.getName());

        //3.通过类名.class获取
        Class clazz3 = ReflectTarget.class;
        System.out.println("3:" + clazz3.getName());

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz3 == clazz2);
    }

}
