package com.example.trelloclone.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  private String name;
  @Column
  private Integer boardId;

  // for deserialisation
  public Status() {
  }

  @JsonCreator
  public Status(@JsonProperty("name") String name, @JsonProperty("boardId") Integer boardId) {
    this.name = name;
    this.boardId = boardId;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getBoardId() {
    return boardId;
  }
  public void setBoardId(Integer boardId) {
    this.boardId = boardId;
  }
  
}
