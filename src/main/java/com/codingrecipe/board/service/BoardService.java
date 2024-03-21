package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  @Transactional
  public void updateHits(long id) {
      boardRepository.updateHits(id); // 데이터 베이스의 해당 id에 해당하는 게시물 조회수를 업데이트
  }

  public BoardDTO findById(long id) {
    Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id); // 주어진 id에 해당하는 게시물을 조회
    if (optionalBoardEntity.isPresent()) {
      BoardEntity boardEntity = optionalBoardEntity.get(); // Optional에서 BoardEntity 객체를 가져옴
      BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity); // BoardEntity를 BoardDTO로 변환
      return boardDTO;
    } else{
      return null;
    }
  }
}
