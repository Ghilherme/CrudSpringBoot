package com.example.contentApp.adapters.persistence;

import com.example.contentApp.domain.Content;
import com.example.contentApp.model.ContentRecord;
import com.example.contentApp.ports.outgoing.ContentPersistence;
import org.hibernate.id.GUIDGenerator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContentRepository extends CrudRepository<ContentRecord, UUID>, ContentPersistence {

    Content findByContentId(UUID Id);

    ContentRecord save(ContentRecord content);


}
