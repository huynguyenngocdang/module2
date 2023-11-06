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

public class JsonFileHandler implements MyFileHandler {
    private final Gson GSON;

    public JsonFileHandler() {
        this.GSON = new GsonBuilder().setPrettyPrinting().create();
    }
    @Override
    public void saveToFile(String filePath, List<?> data) {
        try {
            Writer writer = new FileWriter(filePath);
            GSON.toJson(data, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Can't save to file");
            System.out.println(e.getMessage());
        }
    }
    @Override
    public ArrayList<?> readFromFile(String filePath, Type type) {
        try {
            Reader reader = new FileReader(filePath);
            return GSON.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file to read");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
