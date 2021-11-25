package com.example.contentApp.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @PostMapping(path = "conteudos")
    public ResponseEntity<Object> postContent(@RequestBody ContentContract content){



        return ResponseEntity.ok(content);

    }
}
