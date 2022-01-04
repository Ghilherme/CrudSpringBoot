package com.example.contentApp.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.GUIDGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Content")
public class ContentRecord {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "CONTENT_ID", columnDefinition = "VARCHAR(255)")
    private UUID contentId;

    @NonNull
    @Column(name="CONTENT_NAME")
    private String contentName;

    @NonNull
    @Column(name="CONTENT_DESCRIPTION")
    private String contentDescription;

    @NonNull
    @Column(name="CONTENT_TYPE")
    private int contentType;

    public UUID getId() {
        return contentId;
    }

    public void setId(UUID contentId) {
        contentId = contentId;
    }

    @NonNull
    public String getContentName() {
        return contentName;
    }

    public void setContentName(@NonNull String contentName) {
        this.contentName = contentName;
    }

    @NonNull
    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(@NonNull String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }
}
