package com.pei.liu.springboot;
import java.util.Date;

import com.pei.liu.springboot.demo.spring.ioc.Car;
import com.pei.liu.springboot.demo.spring.ioc.SimpleIoc;
import com.pei.liu.springboot.demo.spring.ioc.Wheel;
import com.pei.liu.springboot.example.codeOptimization.ifelse.InspectionSolver;
import com.pei.liu.springboot.example.codeOptimization.ifelse.InspectionSolverChooser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Test
    public void getBean() throws Exception {
        String location = "/Users/liupei/Desktop/privateProject/springboot/src/main/java/com/pei/liu/springboot/demo/spring/ioc/ioc.xml";
        SimpleIoc simpleIoc =new SimpleIoc(location);
        Wheel wheel = (Wheel) simpleIoc.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) simpleIoc.getBean("car");
        System.out.println(car);
    }




    @Autowired
    private InspectionSolverChooser inspectionSolverChooser;

    @Test
    public void test(){
        String type="ChangeShipping";
        InspectionSolver solver =  inspectionSolverChooser.choose(type);
        solver.solve(12345678L,1234L);
    }




}
