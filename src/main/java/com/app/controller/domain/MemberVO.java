package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable {  // 직렬화가 되는 객체
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
