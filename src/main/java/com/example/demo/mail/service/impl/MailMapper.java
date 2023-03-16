package com.example.demo.mail.service.impl;

import org.springframework.http.ResponseEntity;

import com.example.demo.member.service.MemberVO;

public interface MailMapper {
    ResponseEntity<?> verifiMail(MemberVO memberVO) throws Exception;
}
