package com.example.contentApp.adapters.rest;

import com.example.contentApp.domain.Content;
import com.example.contentApp.ports.incoming.ContentUseCase;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class AppController {

    @Autowired
    ContentUseCase contentUseCase;

    @PostMapping(path = "conteudos")
    public ResponseEntity<Object> postContent(@RequestBody ContentContract content){

        Content cont = new Content();
        cont.setContentName(content.getContentName());
        cont.setContentType(content.getContentType());
        cont.setContentDescription(content.getContentDescription());

        Content response = contentUseCase.save(cont);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllContents(){

        List<Object> list = new ArrayList<Object>();
        contentUseCase.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "{content_id}")
    public ResponseEntity<Object> getContent(String contentId){
        contentUseCase.findById(UUID.fromString(contentId));

        return ResponseEntity.ok(new Object());
    }
}
