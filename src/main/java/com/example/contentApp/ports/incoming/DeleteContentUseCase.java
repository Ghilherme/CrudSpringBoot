package com.example.contentApp.ports.incoming;

import com.example.contentApp.domain.Content;

import java.util.UUID;

public interface DeleteContentUseCase {

    void deleteByID(UUID contentID);
}
