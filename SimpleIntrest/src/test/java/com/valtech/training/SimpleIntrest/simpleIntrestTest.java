package com.valtech.training.SimpleIntrest;

import static org.junit.Assert.*;

import org.junit.Test;

public class simpleIntrestTest {

	@Test
    public void test() {
        simpleInterestImpl si = new simpleInterestImpl();
        assertEquals(12,si.computeInterest(600, 2, 1));
    }

}
