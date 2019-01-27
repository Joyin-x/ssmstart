package com.demo.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wwx
 * @date 2019/1/27 16:02
 **/
public class Image {
    private String img;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
