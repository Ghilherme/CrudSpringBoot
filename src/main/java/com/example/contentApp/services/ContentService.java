package com.example.contentApp.services;

import com.example.contentApp.domain.Content;
import com.example.contentApp.model.ContentModel;
import com.example.contentApp.ports.incoming.CreateContentUseCase;
import com.example.contentApp.ports.incoming.DeleteContentUseCase;
import com.example.contentApp.ports.incoming.FindContentUseCase;
import com.example.contentApp.ports.incoming.UpdateContentUseCase;
import com.example.contentApp.ports.outgoing.ContentPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContentService implements CreateContentUseCase, FindContentUseCase, DeleteContentUseCase, UpdateContentUseCase {


    @Autowired
    ContentPersistencePort contentPersistence;

    @Override
    public List<Content> findAll() {

        List<Content> contents = new ArrayList<Content>();
        Iterable<ContentModel> contentsModel = contentPersistence.findAll();

        for(ContentModel cont: contentsModel ){
            Content newContent = new Content();
            newContent.setId(cont.getId());
            newContent.setContentName(cont.getContentName());
            newContent.setContentType(cont.getContentType());
            newContent.setContentDescription(cont.getContentDescription());
            contents.add(newContent);
        }

        return contents;
    }

    @Override
    public Content findById(UUID id) {

        Optional<ContentModel> content = contentPersistence.findByContentId(id);

        if(content.isPresent())
        {
            Content cont = new Content();
            cont.setId(content.get().getId());
            cont.setContentName(content.get().getContentName());
            cont.setContentType(content.get().getContentType());
            cont.setContentDescription(content.get().getContentDescription());
            cont.setDateTime(content.get().getDateTime());
            return cont;
        }
        else
            return null;
    }

    @Override
    public Content create(Content content) {
        ContentModel contentModel = new ContentModel();
        contentModel.setContentName(content.getContentName());
        contentModel.setContentDescription(content.getContentDescription());
        contentModel.setContentType(content.getContentType());
        contentModel.setDateTime(LocalDateTime.now());

        Content newContent = new Content();
        newContent.setContentName(contentModel.getContentName());
        newContent.setContentDescription(contentModel.getContentDescription());
        newContent.setContentType(contentModel.getContentType());
        newContent.setDateTime(contentModel.getDateTime());

        contentModel = contentPersistence.save(contentModel);

        newContent.setId(contentModel.getId());
        return newContent;
    }

    @Override
    public void deleteByID(UUID contentID) {
        contentPersistence.deleteById(contentID);
    }

    @Override
    public Content update(Content content) {
        ContentModel contentModel = new ContentModel();
        contentModel.setContentId(content.getId());
        contentModel.setContentName(content.getContentName());
        contentModel.setContentDescription(content.getContentDescription());
        contentModel.setContentType(content.getContentType());
        contentModel.setDateTime(LocalDateTime.now());

        Content newContent = new Content();
        newContent.setContentName(contentModel.getContentName());
        newContent.setContentDescription(contentModel.getContentDescription());
        newContent.setContentType(contentModel.getContentType());
        newContent.setDateTime(contentModel.getDateTime());

        contentModel = contentPersistence.save(contentModel);

        newContent.setId(contentModel.getId());
        return newContent;
    }
}
