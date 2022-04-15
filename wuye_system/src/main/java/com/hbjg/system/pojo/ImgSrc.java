package com.hbjg.system.pojo;

import lombok.Data;

@Data
public class ImgSrc {

    private String imgSrc;

    public ImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public ImgSrc() {
    }
}
