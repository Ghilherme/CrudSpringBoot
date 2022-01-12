package com.example.contentApp.ports.incoming;

import com.example.contentApp.domain.Content;

public interface UpdateContentUseCase {

    Content update(Content content);
}
