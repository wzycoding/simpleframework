package demo.reflect;

public class ReflectTargetOrigin {
    String defaultMember = "default";
    public String publicMember = "public";
    protected String protectedMember = "protected";
    private String privateMember = "private";

    public ReflectTargetOrigin() {

    }

    /**
     * 父类私有成员方法
     */
    private void parentMethod1() {
        System.out.println("父类中的private成员方法");
    }

    /**
     * 父类公有成员方法
     */
    public void parentMethod2() {
        System.out.println("父类中的public成员方法");
    }

    /**
     * 父类保护成员方法
     */
    protected void parentMethod3() {
        System.out.println("父类中的protected成员方法");
    }

    /**
     * 父类default成员方法
     */
    void parentMethod4() {
        System.out.println("父类中的default成员方法");
    }
}
