package com.example.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.post.service.PostService;
import com.example.demo.post.service.PostVO;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/selMyPostLst", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> selMyPostLst(@RequestBody PostVO postVO) throws Exception {
        System.out.println(postVO);
        return postService.selMyPostLst(postVO);
    }

    @RequestMapping(value = "/selMyProfileCnt", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> selMyProfileCnt(@RequestBody PostVO postVO) throws Exception {
        System.out.println(postVO);
        return postService.selMyProfileCnt(postVO);
    }
}
