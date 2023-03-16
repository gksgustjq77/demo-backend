package com.example.demo.member.service;

import lombok.Data;

@Data
public class MemberVO {
    
    private Long memberId;
    private String memberUserName;
    private String memberName;
    private String memberUserNick;
    private String memberRole;
    private String memberPassword;
    private String memeberWebstie;
    private String memeberIntroduce;
    private String memberPhone;
    private String memberGender;
    private String memberImageUrl;
    private String memberImageType;
    private String memberImageName;
    private String memberImageUuid;
    private String authCode;
}
