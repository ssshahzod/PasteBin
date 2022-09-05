package com.myproj.controller;

import com.myproj.api.request.PasteRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
public class MainController {

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash){
        return hash;
    }

    @GetMapping("/")
    public Collection<String> getPasteList(){
        return Collections.emptyList();
    }

    @PostMapping("/")
    public String add(@RequestBody PasteRequest pasteRequest){
        return pasteRequest.getText();
    }

}
