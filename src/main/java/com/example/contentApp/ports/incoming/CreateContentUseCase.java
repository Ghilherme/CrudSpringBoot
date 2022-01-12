package com.example.contentApp.ports.incoming;

import com.example.contentApp.domain.Content;

import java.util.List;
import java.util.UUID;

public interface CreateContentUseCase {
    
    Content create(Content content);


}
