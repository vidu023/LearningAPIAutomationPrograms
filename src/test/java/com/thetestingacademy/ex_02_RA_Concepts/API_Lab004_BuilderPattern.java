package com.thetestingacademy.ex_02_RA_Concepts;

public class API_Lab004_BuilderPattern {

     public API_Lab004_BuilderPattern step1(){
        System.out.println("Step 1");
        return this;
    }
    public API_Lab004_BuilderPattern step2(){
        System.out.println("Step 2");
        return this;
    }

    public API_Lab004_BuilderPattern step3(String param1){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        API_Lab004_BuilderPattern bp = new API_Lab004_BuilderPattern();
        bp.step1().step2().step3("Vidya"); // builder pattern uses ..(dot dot)
    }

}
