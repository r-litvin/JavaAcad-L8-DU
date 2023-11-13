package com.engeto.homeworkL8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.engeto.homeworkL8.response.DataSource;

import java.util.HashMap;

@RestController()
public class MainController {

    private HashMap<String, String> data = new HashMap<>();

    @GetMapping("{content}")
    public String provideContent(@PathVariable String content){
        String sourceFile = content + ".txt";
        if(data.containsKey(content)){
            return data.get(content);
        } else {
            DataSource dataReader = new DataSource();
            String textInformation;
            textInformation = dataReader.getFileContents(sourceFile);
            if (!textInformation.isEmpty()){
                data.put(content, textInformation);
                return data.get(content);
            } else {
                return "Information on "+content+" not available.";
            }
        }
    }
}
