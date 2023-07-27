package com.ryanchambers.devicedata.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Console {
    private String fileName;
    private List<BitOverall> testIterations;
    private LocalDateTime lastUpdated;
    private int id;


    public Console(String fileName, List<BitOverall> testIterations) {
        this.fileName = fileName;
        this.testIterations = testIterations;
    }

    public Console(String fileName) {
        this.fileName = fileName;
        testIterations = new ArrayList<>();
    }

    public List<BitOverall> getTestIterations() {
        return testIterations;
    }

    public void setTestIterations(List<BitOverall> testIterations) {
        this.testIterations = testIterations;
    }

    public void addTestIteration(BitOverall bitOverall) {
        testIterations.add(bitOverall);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
