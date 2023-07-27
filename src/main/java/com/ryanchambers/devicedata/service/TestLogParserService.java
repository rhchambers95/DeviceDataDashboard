package com.ryanchambers.devicedata.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.ryanchambers.devicedata.model.BitFunction;
import com.ryanchambers.devicedata.model.BitOverall;
import com.ryanchambers.devicedata.model.Console;
import com.ryanchambers.devicedata.model.TestFileDO;
import com.ryanchambers.devicedata.util.TestLogFileCleaner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestLogParserService {
    private String filename;
    private String cleanFilename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCleanFilename() {
        return cleanFilename;
    }

    public void setCleanFilename(String cleanFilename) {
        this.cleanFilename = cleanFilename;
    }

    public TestLogParserService() {
    }

    public TestLogParserService(String filename) {
        this.filename = filename;
    }

    public Console createConsole() {
        this.cleanFile();

        Console console = new Console(this.filename);
        int foundsHomes = 0;
        List<BitFunction> bitFunctions = new ArrayList<>();

        List<TestFileDO> testFileDOs = this.getTestFileDOs();
        for (int i = 0; i < testFileDOs.size(); i++) {
            TestFileDO tfd = testFileDOs.get(i);
            BitFunction bf = new BitFunction(tfd.getRun(), tfd.getName(), tfd.getPass(), tfd.getResult());
            if (tfd.getName().equals("HOME")) {
                foundsHomes += 1;
            }
            if (foundsHomes == 2 || i == testFileDOs.size() - 1) { // OR i = testFileDos.size() - 1
                console.addTestIteration(new BitOverall(new ArrayList(bitFunctions)));
                bitFunctions.clear();
                foundsHomes = 1;
            }

            bitFunctions.add(bf);
        }
        console.addTestIteration(new BitOverall(bitFunctions));
        return console;
    }

    private List<TestFileDO> getTestFileDOs() {
        List<TestFileDO> results = null;

        try {
            results = new CsvToBeanBuilder(new FileReader(this.cleanFilename)).withType(TestFileDO.class).build().parse();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }

        return results;
    }

    private void cleanFile() {
        this.cleanFilename = TestLogFileCleaner.Clean(this.filename);
    }
}
