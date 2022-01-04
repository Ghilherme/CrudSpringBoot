package com.example.contentApp.services;

import com.example.contentApp.domain.Content;
import com.example.contentApp.model.ContentRecord;
import com.example.contentApp.ports.incoming.ContentUseCase;
import com.example.contentApp.ports.outgoing.ContentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContentService implements ContentUseCase {


    @Autowired
    ContentPersistence contentRepository;

    @Override
    public List<Content> findAll() {
        return null;
    }

    @Override
    public Object findById(UUID id) {

        contentRepository.findByContentId(id);
        return null;
    }

    @Override
    public Content save(Content content) {
        ContentRecord contentRecord = new ContentRecord();

        contentRecord.setContentName(content.getContentName());
        contentRecord.setContentDescription(content.getContentDescription());
        contentRecord.setContentType(content.getContentType());

        contentRepository.save(contentRecord);
        return null;
    }
}
