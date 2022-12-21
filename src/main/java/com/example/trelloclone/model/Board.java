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
@Table(name="board")
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  @Column(name = "name")
  private String name;

  // for deserialisation
  public Board() {}

  @JsonCreator
  public Board(@JsonProperty("name") String name) {
    this.name = name;
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

}