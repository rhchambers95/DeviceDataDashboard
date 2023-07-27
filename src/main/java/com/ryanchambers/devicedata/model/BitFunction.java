package com.ryanchambers.devicedata.model;

import java.time.LocalDateTime;

public class BitFunction {
    private LocalDateTime run;
    private String name;
    private boolean pass;
    private String result;

    public BitFunction(LocalDateTime run, String name, boolean pass, String result) {
        this.run = run;
        this.name = name;
        this.pass = pass;
        this.result = result;
    }

    public BitFunction(TestFileDO testFileDO){
        this(testFileDO.getRun(), testFileDO.getName(), testFileDO.getPass(), testFileDO.getResult());
    }

    public LocalDateTime getRun() {
        return run;
    }

    public void setRun(LocalDateTime run) {
        this.run = run;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
