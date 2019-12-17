package com.pei.liu.springboot.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: springboot
 * @description 不想打破委派模式就重写findClass方法，否则重写loadClass
 * @author: pei.liu
 * @create: 2019-12-01 20:01
 **/
public class MyClassLoader extends ClassLoader {
    String filePath;

    public MyClassLoader(String filePath) {
        super(null);
        this.filePath=filePath;
    }

    @Override
    protected Class<?> findClass(String name)  {
        byte[] classData = null;
        try {
            classData = loadClassData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class c = defineClass(name, classData, 0, classData.length);
        System.out.println("加载" + name + "类成功。");
        return c;

    }

    /**
     * 读取字节码文件
     * @return
     */

    private byte[] loadClassData()  {
        File file = new File(filePath);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
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
            return out.toByteArray();
        }else{
            return null;
        }

    }
}
