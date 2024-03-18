package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

  public List<BoardDTO> findAll() { //BoardEntity 객체들을 조회하여 리스트에 저장
    List<BoardEntity> boardEntityList = boardRepository.findAll(); //BoardDTO 객체들을 저장할 새로운 리스트를 생성
    List<BoardDTO> boardDTOList = new ArrayList<>();
    //모든 BoardEntity 객체에 대해 반복하여 BoardDTO 객체로 변환한 후 리스트에 추가
    for(BoardEntity boardEntity: boardEntityList) {
        boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
    }
    return boardDTOList;
  }
}
