package com.thetestingacademy.ex_02_RA_Concepts;

public class API_Lab003_NP {

     // NoDesignPattern

    public void step1(){
        System.out.println("Step 1");
    }

    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String param1){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        API_Lab003_NP np = new API_Lab003_NP();
        np.step1();
        np.step2();
        np.step3("Vidya");
    }


}
