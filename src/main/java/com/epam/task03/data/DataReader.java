package com.epam.task03.data;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public List<String> readData(String filename) throws DataException {

        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filename)));
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DataException(e.getMessage(), e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOGGER.warn(e.getMessage(), e);
                }
            }
        }
        return lines;
    }

}
