package com.example.demo.mail.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import com.example.demo.member.service.MemberVO;
@Mapper
public interface MailMapper {
    MemberVO selByEmail(MemberVO memberVO) throws Exception;

    void updAuthCode(MemberVO memberVO) throws Exception;
    void updMemberAuth(MemberVO memberVO) throws Exception;
}
