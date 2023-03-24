package com.example.demo.post.service;

import lombok.Data;

@Data
public class PostVO {

    private Long PostImageId;
    private Long MemberId;
    private Long Postid;
    private String PostImageUrl;
    private String PostImageType;
    private String PostImageName;
    private String PostImageUuid;
    private String PostImageAltText;
}
