package com.engeto.homeworkL8.response;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
    private String fileContents="";
    private void read(String fileName) throws MyApiException{
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine())!=null){
                content.append(line).append("\n");
            }
            fileContents = content.toString();

        } catch (FileNotFoundException exc){
            throw new MyApiException("File "+fileName+" not found.");
        } catch (IOException exc){
            throw new MyApiException("Error reading file "+fileName+ ".");
        }
    }

    public String getFileContents(String fileName){
        if (fileContents.isEmpty()){
            try {
                read(fileName);
            } catch (MyApiException exc){
                System.err.println("Error obtaining data from "
                        +fileName+"! "+exc.getLocalizedMessage());
            }

        }
        return fileContents;
    }

}
