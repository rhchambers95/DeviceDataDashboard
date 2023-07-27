package com.ryanchambers.devicedata.service;

import com.ryanchambers.devicedata.dao.BitFunctionDao;
import com.ryanchambers.devicedata.dao.BitOverallDao;
import com.ryanchambers.devicedata.dao.ConsoleDao;
import com.ryanchambers.devicedata.model.BitFunction;
import com.ryanchambers.devicedata.model.BitOverall;
import com.ryanchambers.devicedata.model.Console;
import org.springframework.stereotype.Component;

@Component
public class TestLogService {

    private ConsoleDao consoleDao;
    private BitOverallDao bitOverallDao;
    private BitFunctionDao bitFunctionDao;

    public TestLogService(ConsoleDao consoleDao, BitOverallDao bitOverallDao, BitFunctionDao bitFunctionDao) {
        this.consoleDao = consoleDao;
        this.bitOverallDao = bitOverallDao;
        this.bitFunctionDao = bitFunctionDao;
    }

    public void saveConsole(Console console) {
        consoleDao.create(console);
        for (BitOverall bo : console.getTestIterations()) {
            bitOverallDao.create(bo);

            for (BitFunction bf : bo.getTests()) {
                bitFunctionDao.create(bf);
            }

        }
    }
}
