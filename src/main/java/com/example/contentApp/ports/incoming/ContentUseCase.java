package com.example.contentApp.ports.incoming;

import com.example.contentApp.domain.Content;

import java.util.List;
import java.util.UUID;

public interface ContentUseCase {

    List<Content> findAll();

    Object findById(UUID Id);

    Content save(Content content);


}
