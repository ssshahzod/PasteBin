package com.myproj.repository;

import com.myproj.api.PasteBoxEntity;

import java.util.List;

public interface PasteRepository {
    PasteBoxEntity getByHash(String hash);
    List<PasteBoxEntity> getListOfPublicAndAlive(int amount);
    void add(PasteBoxEntity pasteBoxEntity);
}
