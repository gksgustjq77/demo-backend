package com.example.demo.post.service;

import org.springframework.http.ResponseEntity;

public interface PostService {

    ResponseEntity<?> selMyPostLst(PostVO postVO) throws Exception;

    ResponseEntity<?> selMyProfileCnt(PostVO postVO) throws Exception;

    ResponseEntity<?> selPostLst(PostVO postVO) throws Exception;

    ResponseEntity<?> selCommentLst(PostVO postVO) throws Exception;

}
