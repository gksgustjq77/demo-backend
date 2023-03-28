package com.example.demo.post.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.common.ApiException;
import com.example.demo.common.exception.ApiStatus;
import com.example.demo.post.service.PostService;
import com.example.demo.post.service.PostVO;
import com.example.demo.util.CarmelHashMap;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public ResponseEntity<?> selMyPostLst(PostVO postVO) throws Exception {

        List<CarmelHashMap> selMyPostLst = postMapper.selMyPostLst(postVO);

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", selMyPostLst);
        resultMap.put("result", new ApiException(ApiStatus.AP_SUCCESS, "성공"));
        return new ResponseEntity<>(resultMap, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> selMyProfileCnt(PostVO postVO) throws Exception {

        HashMap<String, Object> resultMap = postMapper.selMyProfileCnt(postVO);

        try {
            // HashMap<String, Object> resultMap = new HashMap<String, Object>();
            // resultMap.put("followCount", count);
            resultMap.put("result", new ApiException(ApiStatus.AP_SUCCESS, "성공"));
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<?> selPostLst(PostVO postVO) throws Exception {

        List<CarmelHashMap> selPostLst = postMapper.selPostLst(postVO);

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", selPostLst);
        resultMap.put("result", new ApiException(ApiStatus.AP_SUCCESS, "성공"));
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> selCommentLst(PostVO postVO) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selCommentLst'");
    }

}
