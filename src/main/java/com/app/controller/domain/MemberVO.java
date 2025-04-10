package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberName;
    private String memberPassword;
    private String memberEmail;
}
