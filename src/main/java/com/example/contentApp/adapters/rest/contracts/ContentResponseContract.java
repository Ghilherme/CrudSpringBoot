package com.example.contentApp.adapters.rest.contracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
public class ContentResponseContract {

    @JsonProperty("id_conteudo")
    private String id;

    @JsonProperty("nome_conteudo")
    private String contentName;

    @JsonProperty("descricao_conteudo")
    private String contentDescription;

    @JsonProperty("tipo_conteudo")
    private Integer contentType;

    @JsonProperty("date_time")
    private LocalDateTime dateTime;

    public String getContentName() {
        return contentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }
}
