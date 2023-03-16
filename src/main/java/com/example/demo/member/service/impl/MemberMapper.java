package com.example.demo.member.service.impl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import com.example.demo.member.service.MemberVO;

@Mapper
public interface MemberMapper {
    int insJoinMember(MemberVO memberVO) throws Exception;
}
