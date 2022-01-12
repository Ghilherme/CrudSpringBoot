package com.example.contentApp.ports.outgoing;

import com.example.contentApp.model.ContentModel;

import java.util.Optional;
import java.util.UUID;

public interface ContentPersistencePort {

    ContentModel save(ContentModel content);

    Optional<ContentModel> findByContentId(UUID id);

    Iterable<ContentModel> findAll();

}
