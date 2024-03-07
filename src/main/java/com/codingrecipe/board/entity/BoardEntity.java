package com.codingrecipe.board.entity;

import com.codingrecipe.board.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// DB 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name = "db_joon")
public class BoardEntity extends BaseEntity {
  @Id // pk 컬럼 지정. 필수
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Long id;

  @Column(length = 20, nullable = false) // 컬럼 크기 값 정할 수 있음(크기 20, not null)
  private String boardWriter;

  @Column // 크기 255, null 가능
  private String boardPass;

  @Column
  private String boardTitle;

  @Column(length = 500)
  private String boardContents;

  @Column
  private int boardHits;

  public static BoardEntity toSaveEntity(BoardDTO boardDTO){  // DTO에 담긴 값들을 Entity에 옮겨담는 작업.
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setBoardWriter(boardDTO.getBoardWriter());
    boardEntity.setBoardPass(boardDTO.getBoardPass());
    boardEntity.setBoardTitle(boardDTO.getBoardTitle());
    boardEntity.setBoardContents(boardDTO.getBoardContents());
    boardEntity.setBoardHits(0);
    return boardEntity;
  }
}
