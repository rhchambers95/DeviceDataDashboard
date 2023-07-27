package com.ryanchambers.devicedata.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TestFileDO {

    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String rawResult;
    @CsvBindByPosition(position = 0)
    @CsvDate("h:mm:ss.SSS a M/d/yyyy")
    private LocalDateTime run;


    public TestFileDO(String name, LocalDateTime run) {
        this.name = name;
        this.run = run;
    }

    public TestFileDO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPass() {
        return rawResult.split(" ")[0].toLowerCase().equals("pass");
    }

    public String getResult() {
        String[] array =  Arrays.copyOfRange(rawResult.split(" "), 1, rawResult.split(" ").length);
        return String.join(" ", array);
    }

    public LocalDateTime getRun() {
        return run;
    }

    public void setRun(LocalDateTime run) {
        this.run = run;
    }
}
