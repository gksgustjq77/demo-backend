package com.example.demo.member.service.impl;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.common.ApiException;
import com.example.demo.common.exception.ApiStatus;
import com.example.demo.config.DemoConfig;
import com.example.demo.mail.service.MailService;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.MemberVO;
import com.example.demo.util.SecurityUtil;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    DemoConfig config;

    @Autowired
    private MailService mailService;

    @Override
    public ResponseEntity<?> insJoinMember(MemberVO memberVO) throws Exception {

        memberVO.setMemberPassword(SecurityUtil.encryptSHA256(memberVO.getMemberPassword()));
        int res = memberMapper.insJoinMember(memberVO);

        if (res != 0)
            mailService.sendMail(memberVO.getMemberUserName());
        else
            return ResponseEntity.ok(new ApiException(ApiStatus.AP_FAIL, "실패"));
        return ResponseEntity.ok(new ApiException(ApiStatus.AP_SUCCESS, "성공"));
    }

    @Override
    public ResponseEntity<?> loginMember(MemberVO memberVO) throws Exception {
        MemberVO memVO = new MemberVO();
        // memVO =
        // Optional.ofNullable(memberMapper.selUserInfo(memberVO)).orElseThrow(EmptyStackException::new);
        memVO = memberMapper.selUserInfo(memberVO);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        if (memVO != null
                && memVO.getMemberPassword().equals(SecurityUtil.encryptSHA256(memberVO.getMemberPassword()))) {
            resultMap.put("data", memVO);
            resultMap.put("result", new ApiException(ApiStatus.AP_SUCCESS, "성공"));
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } else {
            return ResponseEntity.ok(new ApiException(ApiStatus.AP_FAIL, "실패"));
        }

    }
}
