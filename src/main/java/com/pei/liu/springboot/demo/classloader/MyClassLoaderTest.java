package com.pei.liu.springboot.demo.classloader;
import	java.lang.reflect.Method;

/**
 * @program: springboot
 * @description
 * @author: pei.liu
 * @create: 2019-12-01 20:07
 **/
public class MyClassLoaderTest {

    public static void main(String[] args) throws Exception {
        String filepath ="/Users/liupei/Desktop/privateProject/springboot/src/main/java/com/pei/liu/springboot/demo/classloader/ClassLog.class";
        String packageNamePath = "com.pei.liu.springboot.demo.classloader.ClassLog";
        MyClassLoader myClassLoader = new MyClassLoader(filepath);
        Class<?> ClassLog = myClassLoader.loadClass(packageNamePath);
//        这里经常打印的不是自己写的类加载器
//        因为在classpath下已经自动生成了ClassLog的.class 的文件了，把他删除了。
//        还可以指定自定义父加载类为null
        Method method = ClassLog.getDeclaredMethod("main", String[].class);
        Object object = ClassLog.newInstance();
        method.invoke(object, (Object) new String[] {"xxx"});
    }
}
