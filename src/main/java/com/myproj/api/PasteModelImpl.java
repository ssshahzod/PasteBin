package com.myproj.api;

import com.myproj.api.request.PasteRequest;
import com.myproj.api.response.PasteResponse;
import com.myproj.api.response.PasteUrlResponse;
import com.myproj.paste.Status;
import com.myproj.repository.PasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteModelImpl implements PasteModelInterface{

    private String host;
    private int publicListSize = 5;

    private final PasteRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public PasteResponse getByHash(String hash) {
        PasteBoxEntity resultEntity = repository.getByHash(hash);
        return new PasteResponse(resultEntity.getData(), resultEntity.isPublic());
    }

    @Override
    public List<PasteResponse> getFirstPastes() {
        List<PasteBoxEntity> list = repository.getListOfPublicAndAlive(publicListSize);

        return list.stream().map(pasteBoxEntity ->
                new PasteResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic()))
                .collect(Collectors.toList());
    }

    @Override
    public PasteUrlResponse createPaste(PasteRequest pasteRequest) {
        int hash = generateId();
        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setData(pasteRequest.getData());
        pasteBoxEntity.setPublic(pasteRequest.getStatus() == Status.PUBLIC);
        pasteBoxEntity.setHash(Integer.toHexString(hash));
        pasteBoxEntity.setLifetime(LocalDateTime.now().plusSeconds(pasteRequest.getExpirationTimeSeconds()));
        repository.add(pasteBoxEntity);

        return new PasteUrlResponse(host + "/" + pasteBoxEntity.getHash());
    }

    private int generateId(){
        return idGenerator.getAndIncrement();
    }
}
