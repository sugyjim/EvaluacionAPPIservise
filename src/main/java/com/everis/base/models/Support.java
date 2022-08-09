package com.everis.base.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"url", "text"})
public class Support {
    private String url;
    private String text;

    @Override
    public String toString() {
        return "Support{" +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
