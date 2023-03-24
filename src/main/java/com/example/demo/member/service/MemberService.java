package com.example.demo.member.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface MemberService {
    
    ResponseEntity<?> loginMember(MemberVO memberVO) throws Exception;
    ResponseEntity<?> insJoinMember(MemberVO memberVO) throws Exception;
}
