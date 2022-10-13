package com.valtech.training.SimpleIntrest;

import com.valtech.training.Arthimetic;
import com.valtech.training.ArthimeticImpl;

public class simpleInterestImpl  implements simpleIntrest{


    private Arthimetic arithmetic = new ArthimeticImpl();
    public int computeInterest(int prin, int roi, int time) {
        return arithmetic.div(arithmetic.mul(roi, arithmetic.mul(prin, time)), 100);
    }



}