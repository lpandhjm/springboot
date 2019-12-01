package com.pei.liu.springboot.example.codeOptimization.ifelse;

/**
 * @author liupei
 */
public abstract class InspectionSolver {

    public abstract void solve(Long orderId, Long userId);

    public abstract String[] supports();
}
