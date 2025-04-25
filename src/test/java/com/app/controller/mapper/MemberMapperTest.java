package com.app.controller.mapper;

import com.app.controller.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Test
    public void insertTest() {
    MemberVO memberVO = new MemberVO();
    memberVO.setMemberEmail("hgg@gmail.com");
    memberVO.setMemberName("홍길길");
    memberVO.setMemberPassword("1234");
    memberMapper.insert(memberVO);
    }

    @Test
    public void selectTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hgg@gmail.com");
        memberVO.setMemberName("홍길길");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::toString).ifPresent(log::info);
    }
}
