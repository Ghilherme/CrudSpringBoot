package com.example.contentApp.adapters.rest;

import com.example.contentApp.adapters.rest.contracts.ContentContract;
import com.example.contentApp.adapters.rest.contracts.ContentResponseContract;
import com.example.contentApp.domain.Content;
import com.example.contentApp.ports.incoming.CreateContentUseCase;
import com.example.contentApp.ports.incoming.DeleteContentUseCase;
import com.example.contentApp.ports.incoming.FindContentUseCase;
import com.example.contentApp.ports.incoming.UpdateContentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/conteudos")
public class AppController {

    @Autowired
    CreateContentUseCase createContentUseCase;

    @Autowired
    FindContentUseCase findContentUseCase;

    @Autowired
    DeleteContentUseCase deleteContentUseCase;

    @Autowired
    UpdateContentUseCase updateContentUseCase;

    @PostMapping()
    public ResponseEntity<Object> postContent(@RequestBody ContentContract content){

        Content cont = new Content();
        cont.setContentName(content.getContentName());
        cont.setContentType(content.getContentType());
        cont.setContentDescription(content.getContentDescription());


        Content response = createContentUseCase.create(cont);

        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllContents(){

        List<Content> list = findContentUseCase.findAll();

        List<ContentResponseContract> listContents = new ArrayList();

        for (Content content : list) {
            ContentResponseContract responseContent = new ContentResponseContract();
            responseContent.setId(content.getId().toString());
            responseContent.setContentName(content.getContentName());
            responseContent.setContentDescription(content.getContentDescription());
            responseContent.setContentType(content.getContentType());
            responseContent.setDateTime(content.getDateTime());
            listContents.add(responseContent);
        }

        return ResponseEntity.ok(listContents);
    }

    @GetMapping(path = "{content_id}")
    public ResponseEntity<Object> getContent(@PathVariable("content_id") String contentId){
        UUID uuidContent;
        try {
            uuidContent = UUID.fromString(contentId);
        }
        catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body("content id is not a valid UUID");
        }

        Content content = findContentUseCase.findById(uuidContent);

        if(Objects.isNull(content))
            return ResponseEntity.noContent().build();
        else
        {
            ContentResponseContract response = new ContentResponseContract();
            response.setId(content.getId().toString());
            response.setContentName(content.getContentName());
            response.setContentDescription(content.getContentDescription());
            response.setContentType(content.getContentType());
            response.setDateTime(content.getDateTime());

            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping(path = "/{content_id}")
    public ResponseEntity<Object> deleteContent(@PathVariable(value = "content_id") String contentID){
        UUID uuidContent;
        try {
            uuidContent = UUID.fromString(contentID);
        }
        catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body("content id is not a valid UUID");
        }

        Content content = findContentUseCase.findById(uuidContent);

        if(Objects.isNull(content))
            return ResponseEntity.noContent().build();

        deleteContentUseCase.deleteByID(uuidContent);

        ContentResponseContract response = new ContentResponseContract();
        response.setId(content.getId().toString());

        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{content_id}")
    public ResponseEntity<Object> updateContent(@PathVariable(value = "content_id") String contentID,@RequestBody ContentContract contentContract){
        UUID uuidContent;
        try {
            uuidContent = UUID.fromString(contentID);
        }
        catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body("content id is not a valid UUID");
        }

        if(Objects.isNull(findContentUseCase.findById(uuidContent)))
            return ResponseEntity.noContent().build();


        Content cont = new Content();
        cont.setId(uuidContent);
        cont.setContentName(contentContract.getContentName());
        cont.setContentType(contentContract.getContentType());
        cont.setContentDescription(contentContract.getContentDescription());

        cont = updateContentUseCase.update(cont);


        ContentResponseContract response = new ContentResponseContract();
        response.setId(cont.getId().toString());
        response.setId(cont.getId().toString());
        response.setContentName(cont.getContentName());
        response.setContentDescription(cont.getContentDescription());
        response.setContentType(cont.getContentType());
        response.setDateTime(cont.getDateTime());

        return ResponseEntity.ok(response);
    }
}
