package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private String name;
    private int age;

}
