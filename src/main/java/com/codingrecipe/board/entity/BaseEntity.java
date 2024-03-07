package com.codingrecipe.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter

public class BaseEntity {
  @CreationTimestamp  // 데이터가 생성되었을 때 시간을 만들어줌
  @Column(updatable = false) // 수정 시에 관여 안함
  private LocalDateTime createdTime;

  @UpdateTimestamp
  @Column(insertable = false) // 입력 시에 관여 안함
  private LocalDateTime updatedTime;
}
