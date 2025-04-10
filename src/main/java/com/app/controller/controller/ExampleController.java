package com.app.controller.controller;

import com.app.controller.domain.ProductVO;
import com.app.controller.domain.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

//    localhost:10000/ex/ex01
    @GetMapping("ex01")
    public void ex01() {
        log.info("여기 실행됨!");
    };

//    ex/ex02?name=홍길동
    @GetMapping("ex02")
    public void ex02(String name, Model model) {
        log.info(name);
        model.addAttribute("name", name);
    };

    // 이름과 나이를 화면으로 보내서, 이름, 나이, 만나이(나이-1)를 출력하기
    @GetMapping("ex03")
    public void ex03(int age, String name, Model model) {
        log.info(name);
        log.info("{}", age);
        model.addAttribute("name", name);
        model.addAttribute("age", age);

    };

//    ex04
//    직업, 이름
    @GetMapping("ex04")
    public void ex04(@RequestParam("job") String job, @RequestParam("name") String name, Model model) {
        log.info(name);
        log.info("{}", job);
        model.addAttribute("name", name);
        model.addAttribute("job", job);
    }


//    ex05
//    화면에서 userVO 받기
    @GetMapping("ex05")
    public void ex05(UserVO userVO){
        log.info(userVO.toString());
    }

//    상품이름(productName) 상품가격(productPrice)
//    productVO로 생성한 후
//    화면에서 ex06으로 상품명과 상품가격을 받아서 요청했을 때
//    log로 productVO 출력하기!

    @GetMapping("ex06")
    public void ex06(@ModelAttribute ProductVO productVO){ // 값을 받자마자 화면으로 바로 보낸다.
        log.info(productVO.toString());
    }


}
