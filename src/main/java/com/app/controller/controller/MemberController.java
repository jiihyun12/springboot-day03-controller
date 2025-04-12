package com.app.controller.controller;

import com.app.controller.domain.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.app.controller.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;

    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO){;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberMapper.insert(memberVO);
        return new RedirectView("/member/login");

    }

    @GetMapping("login")
    public void goToLoginForm(MemberVO memberVO){;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes){
       Optional<MemberVO> foundMember = memberMapper.select(memberVO);
       if(foundMember.isPresent()){
           session.setAttribute("member", foundMember.get());
           session.setAttribute("product", foundMember.get());
            return new RedirectView("/post/list");
       }
       return new RedirectView("/member/login");
    }

//    로그아웃
    @GetMapping("logout") // 서버가 하나만 있어서 GetMapping이지만, 서버가 두 개일때는 Post
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/member/login");

    }


}
