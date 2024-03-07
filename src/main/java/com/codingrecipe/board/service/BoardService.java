package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//DTO -> Entity (Entity 클래스)
//Entity -> DTO 변환 (DTO 클래스)

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository; // 의존성 주입.
  public void save(BoardDTO boardDTO) {
    BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
    boardRepository.save(boardEntity);

  }
}
