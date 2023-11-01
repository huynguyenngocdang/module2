package com.codegym.huyc08.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyFileHandler implements JsonFileHandler {
    private final Gson GSON;

    public MyFileHandler() {
        this.GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void saveToFile(String filePath, List<?> data) {
        try {
            Writer writer = new FileWriter(filePath);
            GSON.toJson(data, writer);
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public ArrayList<?> readFromFile(String filePath, Type type) {
        try {
            Reader reader = new FileReader(filePath);
            return GSON.fromJson(reader, type);
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

}
