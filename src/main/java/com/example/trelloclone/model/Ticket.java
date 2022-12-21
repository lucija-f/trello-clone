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
@Table(name="ticket")
public class Ticket {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  private String title;
  @Column
  private String description;
  @Column
  private Integer statusId;

  // for deserialisation
  public Ticket() {}

  @JsonCreator
  public Ticket(@JsonProperty("title") String title, @JsonProperty("description") String description, @JsonProperty("statusId") Integer statusId) {
    this.title = title;
    this.description = description;
    this.statusId = statusId;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Integer getStatusId() {
    return statusId;
  }
  public void setStatusId(Integer statusId) {
    this.statusId = statusId;
  }

  
}
