package com.pei.liu.springboot.demo.design.proxy.jdk.self;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-08 20:10
 * @version: 1.0$
 */
public class LPClassLoader extends ClassLoader {

    private File baseDir;

    public LPClassLoader() {
        String basePath = LPClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);

    }

    @Override
    protected Class<?> findClass(String name)  {
        String className = LPClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File classFile = new File(baseDir,name+".class");
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            byte[] classData = out.toByteArray();
            System.out.println("加载" + name + "类成功。");
            return  defineClass(className, classData, 0, classData.length);
        }
        return null;
    }

}
