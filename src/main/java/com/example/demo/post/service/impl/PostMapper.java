package com.example.demo.post.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.post.service.PostVO;
import com.example.demo.util.CarmelHashMap;

@Mapper
public interface PostMapper {

    List<CarmelHashMap> selMyPostLst(PostVO postVO) throws Exception;

    HashMap<String, Object> selMyProfileCnt(PostVO postVO) throws Exception;

    List<CarmelHashMap> selPostLst(PostVO postVO) throws Exception;
}
