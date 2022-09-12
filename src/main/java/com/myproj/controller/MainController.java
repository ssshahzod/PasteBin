package com.myproj.controller;

import com.myproj.api.PasteModelInterface;
import com.myproj.api.request.PasteRequest;
import com.myproj.api.response.PasteResponse;
import com.myproj.api.response.PasteUrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final PasteModelInterface  pasteModel;

    @GetMapping("/{hash}")
    public PasteResponse getByHash(@PathVariable String hash){
        return pasteModel.getByHash(hash);
    }

    @GetMapping("/")
    public Collection<PasteResponse> getPasteList(){
        return pasteModel.getFirstPastes();
    }

    @PostMapping("/")
    public PasteUrlResponse add(@RequestBody PasteRequest pasteRequest){
        return pasteModel.createPaste(pasteRequest);
    }

}
