package com.myproj.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteUrlResponse {
    private final String url;
}
