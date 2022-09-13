package com.myproj.repository;

import com.myproj.api.PasteBoxEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PasteRepositoryImpl implements PasteRepository{

    private final Map<String, PasteBoxEntity> vault = new ConcurrentHashMap<>();

    @Override
    public PasteBoxEntity getByHash(String hash) {
        PasteBoxEntity res = vault.get(hash);
        if(res == null){
            throw new EntityNotFoundException("Not found entity with hash: " + hash);
        }
        return res;
    }

    @Override
    //TODO: remove int amount param
    //it should be parsed from applicatoin.properties
    public List<PasteBoxEntity> getListOfPublicAndAlive(int amount) {
        LocalDateTime nowTimestamp = LocalDateTime.now();
        return vault.values()
                .stream()
                .filter(PasteBoxEntity::isPublic)
                .filter(pasteBoxEntity -> pasteBoxEntity.getLifetime().isAfter(nowTimestamp))
                .sorted(Comparator.comparing(PasteBoxEntity::getId))
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PasteBoxEntity pasteBoxEntity) {
        vault.put(pasteBoxEntity.getHash(), pasteBoxEntity);
    }
}
