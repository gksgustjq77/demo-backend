package com.example.demo.mail.service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.common.ApiException;
import com.example.demo.common.exception.ApiStatus;
import com.example.demo.config.DemoConfig;
import com.example.demo.config.MailConfig;
import com.example.demo.mail.service.impl.MailMapper;
import com.example.demo.member.service.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import java.util.UUID;

import javax.mail.internet.MimeMessage;

@Service

public class MailService {
    @Autowired
    DemoConfig config;
    
    @Autowired
    MailConfig mailConfig;

    @Autowired
    MailMapper mailMapper;

    @Autowired
    private static JavaMailSender mailSender;

    @Autowired
    private MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public MimeMessage createMessage(String code, String email) throws Exception {
        String setFrom = "gksgustjq77@naver.com";
     
        MimeMessage message = mailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, email);
        message.setSubject("demo 인증 번호입니다.");
        message.setText("이메일 인증코드: " + code);

        message.setFrom(setFrom);

        return message;
    }
    
    public void sendMail(String email) throws Exception {
        String authCode = UUID.randomUUID().toString().substring(0, 6);
      
        try {
            MimeMessage mimeMessage = createMessage(authCode, email);
            mailSender.send(mimeMessage);

            MemberVO memVO = new MemberVO();
            memVO.setMemberAuthCode(authCode);
            memVO.setMemberUserName(email);
            mailMapper.updAuthCode(memVO);
        } catch (MailException mailException) {
            mailException.printStackTrace();
            throw new IllegalAccessException();
        }
    }
    
    public ResponseEntity<?> verifiCation(MemberVO memberVO) throws Exception {
        MemberVO memVO = new MemberVO();
        try {
            memVO = mailMapper.selByEmail(memberVO);
        
            if (memVO.getMemberAuthCode().equals(memberVO.getMemberAuthCode())) {
                mailMapper.updMemberAuth(memVO);
            }

          return ResponseEntity.ok(new ApiException(ApiStatus.AP_SUCCESS, "성공"));   
        } catch (Exception e) {
          return ResponseEntity.ok(new ApiException(ApiStatus.AP_FAIL));  
        }
    }
}
 