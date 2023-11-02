package com.codegym.huyc08.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface MyFileHandler {
    void saveToFile(String filePath, List<?> data);
    ArrayList<?> readFromFile(String filePath, Type type);
}
