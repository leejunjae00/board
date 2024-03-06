package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/")
  public String index(){ //루트 URL에 대한 핸들러, "index" 뷰로 해석해야함
    return "index";
  }
}
