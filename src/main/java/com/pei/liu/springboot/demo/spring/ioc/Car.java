package com.pei.liu.springboot.demo.spring.ioc;

/**
 * @description：ioc测试使用bean
 * @author：liupei
 * @create: 2019-12-04 20:36
 * @version: 1.0$
 */
public class Car {

    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", length='").append(length).append('\'');
        sb.append(", width='").append(width).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", wheel=").append(wheel);
        sb.append('}');
        return sb.toString();
    }
}
