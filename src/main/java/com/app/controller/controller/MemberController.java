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
@RequestMapping("/member/*")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;

    // 포워드 --> void foword
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO){;} // 아무것도 하지 않고 보내기만 한다.

    // 리다이렉트
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){ // 그대로 insert
        log.info(memberVO.toString());
        memberMapper.insert(memberVO);
//        return "forward:/member.login" // 리턴할 때 포워드
        return new RedirectView("/member/login");
    }

//    로그인 페이지 이동
    @GetMapping("login")
    public void goToLogin(MemberVO memberVO){;}

//    로그인
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes){
        log.info(memberVO.toString());
        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
        if(foundMember.isPresent()){
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/post/list");
        }

        session.setAttribute("member", null);


//        로그인 실패
//        session.flash 영역
//        session이 과부화 되므로, session에 flash 영역을 사용하여
//        화면으로 상태 값을 보내고, new Request가 되면 session에 flash 값이 새로 주입되며 기존 flash 값이 사라진다.
//        따라서 과부화의 부담이 줄어든다.


        redirectAttributes.addFlashAttribute("login", false);
        return new RedirectView("/member/login");



    }
}
