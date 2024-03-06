package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board") //이 컨트롤러의 모든 메서드에 대한 URL은 "/board"로 시작.
public class BoardController {
  @GetMapping("/save") // "/board/save" 경로에 대한 GET 요청을 처리하는 메서드를 정의.
  public String saveForm() { //"save"라는 이름의 뷰를 찾아 렌더링하도록 지시.
    return "save";
  }
}
