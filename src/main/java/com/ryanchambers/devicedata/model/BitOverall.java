package com.ryanchambers.devicedata.model;

import java.util.List;

public class BitOverall {

    private List<BitFunction> tests;



    public BitOverall(List<BitFunction> tests) {
        this.tests = tests;
    }

    public List<BitFunction> getTests() {
        return tests;
    }

    public void setTests(List<BitFunction> tests) {
        this.tests = tests;
    }

}
