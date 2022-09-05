package com.myproj.api;

import com.myproj.api.request.PasteRequest;
import com.myproj.api.response.PasteResponse;
import com.myproj.api.response.PasteUrlResponse;

import java.util.List;

public class PasteModelImpl implements PasteModelInterface{

    @Override
    public PasteResponse getByHash(String hash) {
        return null;
    }

    @Override
    public List<PasteResponse> getFirstPastes(int amount) {
        return null;
    }

    @Override
    public PasteUrlResponse createPaste(PasteRequest pasteRequest) {
        return null;
    }
}
