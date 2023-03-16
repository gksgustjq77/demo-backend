package com.example.demo.mail;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.service.MailService;
import com.example.demo.member.service.MemberVO;

@RestController
@RequestMapping(value = "/api/v1/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping(value="/verifi", method = RequestMethod.POST)
    @ResponseBody
     public ResponseEntity<?> join(@RequestBody MemberVO memberVO, HttpServletRequest request) throws Exception {
    return mailService.verifiCation(memberVO);
    
    // memberService.insJoinMember(memberVO);
    // ApiException msg = ;    
    // return new ResponseEntity<ApiException>(msg, HttpStatus.OK);new ApiException(ApiStatus.AP_SUCCESS, "성공")
	}
}
