package com.pei.liu.springboot;

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
    public void contextLoads() {
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
