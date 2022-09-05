package com.myproj.api.response;

import com.myproj.paste.Status;
import lombok.Data;

@Data
public class PasteResponse {
    private String text;
    private Status status;
}
