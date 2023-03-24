package com.example.demo.follows.service;

import lombok.Data;

@Data
public class FollowsVO {

    private Long followId;
    private Long followMemberId;
    private Long memberId;
}
