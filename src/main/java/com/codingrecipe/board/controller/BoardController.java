package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board") //이 컨트롤러의 모든 메서드에 대한 URL은 "/board"로 시작.
public class BoardController {
  @GetMapping("/save") // "/board/save" 경로에 대한 GET 요청을 처리하는 메서드를 정의.
  public String saveForm() { return "save"; } //"save"라는 이름의 뷰를 찾아 렌더링하도록 지시.

  @PostMapping("/save")
  public String save(@ModelAttribute BoardDTO boardDTO){  //BoardDTO 객체를 찾아서 save.html에
    System.out.println("boardDTO = " + boardDTO);
    return null;                                          //이름과 DTO 필드 값과 동일하면 해당하는 세터를 호출하고 담아줌
  }
}
