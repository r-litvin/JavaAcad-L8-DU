package com.engeto.homeworkL8.response;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fileReader {
    private static String fileContents="";
    public static void read(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine())!=null){
                content.append(line).append("\n");
            }
            fileContents = content.toString();


        } catch (FileNotFoundException exc){
            System.err.println("File "+fileName+" not found. "+exc.getLocalizedMessage());
        } catch (IOException exc){
            System.err.println("Error reading file "+fileName+ " "+exc.getLocalizedMessage());
        }
    }

    public static String getFileContents(String fileName) {
        if (fileContents.isEmpty()){
            read(fileName);
        }
        return fileContents;
    }

}
