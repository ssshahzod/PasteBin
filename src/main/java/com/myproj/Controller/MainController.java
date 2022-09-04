package com.myproj.Controller;

import com.myproj.Paste.Paste;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    public String add(@RequestBody Paste paste){
        return paste.getText();
    }

}
