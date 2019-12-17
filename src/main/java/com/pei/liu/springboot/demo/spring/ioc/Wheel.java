package com.pei.liu.springboot.demo.spring.ioc;

/**
 * @description：测试bean
 * @author：liupei
 * @create: 2019-12-04 20:41
 * @version: 1.0$
 */
public class Wheel {
    private String brand;
    private String specification ;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wheel{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", specification='").append(specification).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
