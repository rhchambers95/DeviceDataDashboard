package com.ryanchambers.devicedata.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TestLogFileCleaner {
    public static void RemoveSingleQuotes(String filename) {
        List<String> output = new ArrayList<String>();
        try {
            BufferedReader fr = new BufferedReader(new FileReader(filename));
            String line = fr.readLine();
            while (line != null) {
                if (line.startsWith("'")) {
                    line = line.substring(1);
                }
                output.add(line);
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Blew up:" + e.getMessage());
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename + "clean"));
            for (String line : output) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (Exception e) {
            System.out.println("Blew up: " + e.getMessage());
        }
    }

    public static void RemoveEndingCommas(String filename) {

    }

    public static String Clean(String filename) {
        RemoveSingleQuotes(filename);
        RemoveEndingCommas(filename);
        return filename + "clean";
    }
}
