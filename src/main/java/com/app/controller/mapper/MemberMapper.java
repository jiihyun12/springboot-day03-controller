package com.app.controller.mapper;

import com.app.controller.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);

    public Optional<MemberVO> select(MemberVO memberVO);
}
