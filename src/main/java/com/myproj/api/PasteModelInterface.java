package com.myproj.api;

import com.myproj.api.request.PasteRequest;
import com.myproj.api.response.PasteResponse;
import com.myproj.api.response.PasteUrlResponse;

import java.util.List;

public interface PasteModelInterface {
    PasteResponse getByHash(String hash);
    List<PasteResponse> getFirstPastes(int amount);
    PasteUrlResponse createPaste(PasteRequest pasteRequest);
}
