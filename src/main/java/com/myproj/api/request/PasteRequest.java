package com.myproj.api.request;

import com.myproj.paste.Status;
import lombok.Data;

@Data
public class PasteRequest {
    private String text;
    private Status status;
    private long expirationTimeSeconds;
}
