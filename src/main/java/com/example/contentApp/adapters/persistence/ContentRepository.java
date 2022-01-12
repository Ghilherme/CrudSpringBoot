package com.example.contentApp.adapters.persistence;

import com.example.contentApp.model.ContentModel;
import com.example.contentApp.ports.outgoing.ContentPersistencePort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContentRepository extends CrudRepository<ContentModel, UUID>, ContentPersistencePort {

}
