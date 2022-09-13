package com.myproj.pastebin;


import com.myproj.api.PasteBoxEntity;
import com.myproj.api.PasteModelImpl;
import com.myproj.api.response.PasteResponse;
import com.myproj.repository.EntityNotFoundException;
import com.myproj.repository.PasteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteServiceTest {
    @Autowired
    private PasteModelImpl pasteModel;

    @MockBean
    private PasteRepository pasteRepository;

    @Test
    public void notExistHash(){
        assertThrows(EntityNotFoundException.class, () -> pasteModel.getByHash("asdasd"));
    }

    @Test
    public void gotExistHash(){
        PasteBoxEntity entity = new PasteBoxEntity();
        entity.setHash("1");
        entity.setData("Test");
        entity.setPublic(true);

        when(pasteRepository.getByHash("1")).thenReturn(entity);

        PasteResponse expected = new PasteResponse("Test", true);
        PasteResponse actual = pasteModel.getByHash("1");

        assertEquals(actual.hashCode(), expected.hashCode());
    }

}
