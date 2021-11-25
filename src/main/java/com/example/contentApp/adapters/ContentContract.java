package com.example.contentApp.adapters;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ContentContract implements Serializable {

    @JsonProperty("nome_conteudo")
    public String contentName;

    @JsonProperty("descricao_conteudo")
    public String contentDescription;

    @JsonProperty("tipo_conteudo")
    public int contentType;

    public String getContentName() {
        return contentName;
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
