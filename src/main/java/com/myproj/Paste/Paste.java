package com.myproj.Paste;

import lombok.Data;

@Data
public class Paste {
    private String text;
    private Status status;
    private long expirationTimeSeconds;

}
