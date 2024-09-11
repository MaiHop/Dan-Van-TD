package com.example.danvantd.Domain.Model;

import java.io.Serializable;

public class Image implements Serializable {
    private String src, content;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
