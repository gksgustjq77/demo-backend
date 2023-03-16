package com.example.demo.member;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.ApiException;
import com.example.demo.common.exception.ApiStatus;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.MemberVO;
import com.mysql.cj.protocol.Message;


@RestController
@RequestMapping(value = "/api/v1/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, Object> sample, HttpServletRequest request)
            throws Exception {
        System.out.println(sample);
        return null;
    }
    
    @RequestMapping(value="/join", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> join(@RequestBody MemberVO memberVO, HttpServletRequest request) throws Exception {
    return memberService.insJoinMember(memberVO);
    
    // memberService.insJoinMember(memberVO);
    // ApiException msg = ;    
    // return new ResponseEntity<ApiException>(msg, HttpStatus.OK);new ApiException(ApiStatus.AP_SUCCESS, "성공")
	}
}
