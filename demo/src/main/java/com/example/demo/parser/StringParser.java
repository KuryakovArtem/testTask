package com.example.demo.parser;

import com.example.demo.operations.Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class StringParser {

    public StringParser() {
    }

    public ArrayList<String> parseString(String string){
    String delims =",";
    String [] tokens = string.split(delims);
    return new ArrayList<>(Arrays.asList(tokens));
}
}
