package com.myproj.api.response;

import com.myproj.paste.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteResponse {
    private final String data;
    private final boolean isPublic;
}
