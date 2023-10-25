package com.codegym.huy_c08.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyFileHandler {
    private final Gson GSON;

    public MyFileHandler() {
        this.GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveToFile(String fileName, ArrayList<?> data) {
        try {
            Writer writer = new FileWriter(fileName);
            GSON.toJson(data, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Can't write file");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<?> readFromFile(String fileName, Type type) {
        try  {
            Reader reader = new FileReader(fileName);
            return GSON.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Can't read file");
            System.out.println(e.getMessage());
        }
        return null;
    }


}
