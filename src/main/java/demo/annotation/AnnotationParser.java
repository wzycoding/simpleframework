package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 解析注解类
 */
public class AnnotationParser {
    //解析类的注解
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("demo.annotation.ImoocCourse");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotation;
            System.out.println("课程名称：" + courseInfoAnnotation.courseName() + "\n" +
                    "课程标签：" + courseInfoAnnotation.courseTag() + "\n" +
                    "课程简介：" + courseInfoAnnotation.courseProfile() + "\n" +
                    "课程编号：" + courseInfoAnnotation.courseIndex());
        }
    }

    //解析成员变量上的标签
    public static void parseFieldAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("demo.annotation.ImoocCourse");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(PersonInfoAnnotation.class)) {
                PersonInfoAnnotation personInfoAnnotation = declaredField.getAnnotation(PersonInfoAnnotation.class);
                System.out.print("姓名：" + personInfoAnnotation.name() + "\n" +
                        "性别：" + personInfoAnnotation.gender() + "\n" +
                        "年龄：" + personInfoAnnotation.age() + "\n" +
                        "语言：");
                String[] language = personInfoAnnotation.language();
                for (String s : language) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }

    public static void parseMethodAnnotation() {
        Class clazz = ImoocCourse.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(CourseInfoAnnotation.class)) {
                CourseInfoAnnotation courseInfoAnnotation = declaredMethod.getAnnotation(CourseInfoAnnotation.class);
                System.out.println("课程名称：" + courseInfoAnnotation.courseName() + "\n" +
                        "课程标签：" + courseInfoAnnotation.courseTag() + "\n" +
                        "课程简介：" + courseInfoAnnotation.courseProfile() + "\n" +
                        "课程编号：" + courseInfoAnnotation.courseIndex());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("======================");
//        parseTypeAnnotation();
        System.out.println("======================");
        parseFieldAnnotation();
        System.out.println("======================");
//        parseMethodAnnotation();
    }
}
