package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
   private int productPrice;
   private String productName;
}
