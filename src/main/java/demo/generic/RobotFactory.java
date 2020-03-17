package demo.generic;

import java.util.Random;

/**
 * 泛型接口实现类：随机返回一个字符串和一个整数
 */
public class RobotFactory implements GenericIFactory<String ,Integer> {
    private String [] stringRobot = new String[] {"hello", "Hi"};
    private Integer [] integerRobot = new Integer[] {111, 222};
    @Override
    public String nextObject() {
        Random random = new Random();
        return stringRobot[random.nextInt(2)]; // [0,2)
    }

    @Override
    public Integer nextNumber() {
        Random random = new Random();
        return integerRobot[random.nextInt(2)]; // [0,2)
    }

    public static void main(String[] args) {
        GenericIFactory<String, Integer> factory = new RobotFactory();
        System.out.println(factory.nextNumber());
        System.out.println(factory.nextObject());
    }
}
