package com.engeto.homeworkL8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.engeto.homeworkL8.response.fileReader;

@RestController()
public class MainController {
    private String scifi="";
    private String romantic="";
    private String historic="";

    @GetMapping("scifi")
    public String scifi(){
        if (scifi.isEmpty()){
            scifi = fileReader.getFileContents("scifi.txt");
        }
        return scifi;
    }

    @GetMapping("romantic")
    public String romantic(){
        if (romantic.isEmpty()){
            romantic = fileReader.getFileContents("scifi.txt");
        }
        return romantic;
    }


    @GetMapping("historic")
    public String historic(){
        if (historic.isEmpty()){
            historic = fileReader.getFileContents("scifi.txt");
        }
        return historic;
    }

}
