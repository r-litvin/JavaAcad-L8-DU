package com.engeto.homeworkL8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.engeto.homeworkL8.response.DataSource;

@RestController()
public class MainController {
    private String scifi="";
    private String romantic="";
    private String historic="";

    public MainController(){
        DataSource scifiReader = new DataSource();
        scifi = scifiReader.getFileContents("scifi.txt");
        DataSource romanticReader = new DataSource();
        romantic = romanticReader.getFileContents("romantic.txt");
        DataSource historicReader = new DataSource();
        historic = historicReader.getFileContents("historic.txt");
    }

    @GetMapping("scifi")
    public String scifi(){
        return scifi;
    }

    @GetMapping("romantic")
    public String romantic(){
        return romantic;
    }

    @GetMapping("historic")
    public String historic(){
        return historic;
    }

}
