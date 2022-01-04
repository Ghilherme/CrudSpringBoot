package com.example.contentApp.ports.outgoing;

import com.example.contentApp.domain.Content;
import com.example.contentApp.model.ContentRecord;
import org.hibernate.id.GUIDGenerator;

import java.util.UUID;

public interface ContentPersistence {

    Content findByContentId(UUID Id);

    ContentRecord save(ContentRecord content);

}
