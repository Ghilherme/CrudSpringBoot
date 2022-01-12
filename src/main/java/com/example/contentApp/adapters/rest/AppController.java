package com.example.contentApp.adapters.rest;

import com.example.contentApp.adapters.rest.contracts.ContentContract;
import com.example.contentApp.adapters.rest.contracts.ContentResponseContract;
import com.example.contentApp.domain.Content;
import com.example.contentApp.ports.incoming.CreateContentUseCase;
import com.example.contentApp.ports.incoming.FindContentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
}
