package com.example.demo.member.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MemberServiceImpl implements MemberService{

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
      
      if(res != 0) mailService.sendMail(memberVO.getMemberUserName()); 
      else return ResponseEntity.ok(new ApiException(ApiStatus.AP_FAIL, "실패"));
      return ResponseEntity.ok(new ApiException(ApiStatus.AP_SUCCESS, "성공"));
    }
    


}
