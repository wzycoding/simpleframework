package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包下类集合
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        //1.获取到类的加载器


        ClassLoader classLoader = getClassLoader();
        //根据包名获取，获取要通过/这种路径方式获取
        //2.通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("unable to retrieve anything from package: " + packageName);
            return null;
        }
        //3.依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        // file:/Users/blusk123/Project/simpleframework/target/classes/com/imooc/entity
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDirect = new File(url.getPath());
            extractClassFile(classSet, packageDirect, packageName);
        }
        return classSet;
    }

    /**
     * 递归获取目标package里面所有class文件（包括子package里的class文件）
     * @param emptyClassSet
     * @param fileSource
     * @param packageName
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        //递归，第一步能够推进，第二步能终止
        if (!fileSource.isDirectory()) {
            return;
        }
        //如果是一个文件夹，则调用其listFiles方法获取文件夹下的文件或者文件夹
        File [] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    //获取文件的绝对值路径
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(".class")) {
                        //若是class文件，则直接加载
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            private void addToClassSet(String absoluteFilePath) {
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf("."));
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });

        //这里必须判空
        if (files != null) {
            for (File f : files) {
                //递归调用
                extractClassFile(emptyClassSet, f, packageName);
            }
        }
    }

    /**
     * 获取当前ClassLoader
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取class对象
     * @param className
     * @return
     */
    private static Class<?> loadClass(String className) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("class not found!");
            throw new RuntimeException();
        }
        return aClass;
    }

    public static void main(String[] args) {
        Set<Class<?>> classSet = extractPackageClass("com.imooc.entity");
        System.out.println(classSet);
        System.out.println(classSet.size());
    }
}
