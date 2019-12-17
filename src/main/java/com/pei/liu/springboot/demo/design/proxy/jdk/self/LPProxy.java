package com.pei.liu.springboot.demo.design.proxy.jdk.self;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-08 20:09
 * @version: 1.0$
 */
//    生成代理对象
public class LPProxy {
    public static Object newProxyInstance(LPClassLoader loader,
                                          Class<?>[] interfaces,
                                          LPInvocationHandler h)
            throws IllegalArgumentException {
        try {


//        1.生成源代码
            String proxyStr = genrateSrc(interfaces[0]);
//        2.将源代码输出到磁盘保存.java文件
            String filePath = LPProxy.class.getResource("").getPath();
//        String filePath = "/Users/liupei/Desktop/privateProject/springboot/src/main/java/com/pei/liu/springboot/demo/design/proxy/jdk/self/";
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(proxyStr);
            fileWriter.close();
//        3。编译源代码。class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable =manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
//        4。加载。class
//        5。返回被代理对象
            Class<?> proxyClass = loader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(LPInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String genrateSrc(Class<?> interfaces) {
        String ln = "\n\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package com.pei.liu.springboot.demo.design.proxy.jdk.self; \n\n");
        stringBuilder.append("import java.lang.reflect.Method;" + ln);
        stringBuilder.append("public  class $Proxy0 extends LPProxy implements   " + interfaces.getName() + "{" + ln);
        stringBuilder.append("LPInvocationHandler h;" + ln);
        stringBuilder.append("public $Proxy0(LPInvocationHandler h) {" + ln);
        stringBuilder.append("this.h =h;" + ln);
        stringBuilder.append("}" + ln);

        for (Method m : interfaces.getMethods()) {

            stringBuilder.append("public " + m.getReturnType().getName() + "   " + m.getName() + "() {" + ln);
            stringBuilder.append("Method m= null;");
            stringBuilder.append("try{" + ln);
            stringBuilder.append(" m=" + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            stringBuilder.append("}");
            stringBuilder.append("catch(Exception e){" + ln);
            stringBuilder.append(" e.printStackTrace();" + ln);
            stringBuilder.append("}" + ln);
            stringBuilder.append("try{" + ln);
            stringBuilder.append("this.h.invoke(this,m,null); " + ln);
            stringBuilder.append("}");
            stringBuilder.append("catch(Throwable throwable){" + ln);
            stringBuilder.append("throwable.printStackTrace();" + ln);
            stringBuilder.append("}" + ln);
            stringBuilder.append("}" + ln);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}