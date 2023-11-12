package com.engeto.homeworkL8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.engeto.homeworkL8.response.FileReader;

@RestController()
public class MainController {
    private String scifi="";
    private String romantic="";
    private String historic="";

    public MainController(){
        FileReader scifiReader = new FileReader();
        scifi = scifiReader.getFileContents("scifi.txt");
        FileReader romanticReader = new FileReader();
        romantic = romanticReader.getFileContents("romantic.txt");
        FileReader historicReader = new FileReader();
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
