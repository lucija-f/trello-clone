package com.example.trelloclone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trelloclone.model.Status;
import com.example.trelloclone.service.StatusService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class StatusController {

  @Autowired
  private StatusService statusService;

  @GetMapping(value="/statuses")
  public ResponseEntity<List<Status>> getAllStatuses() {
      return ResponseEntity.ok().body(statusService.getAllStatuses());
  }

  @PostMapping(value="/statuses")
  public ResponseEntity<Status> createStatus(@RequestBody Status status) {
      return ResponseEntity.ok().body(statusService.createStatus(status));
  }

  @GetMapping(value="/statuses/{id}")
  public ResponseEntity<Status> getStatus(@PathVariable Integer id) {
      return ResponseEntity.ok().body(statusService.getStatusById(id));
  }
  
  @PatchMapping(value="/statuses/{id}")
  public ResponseEntity<Status> updateStatus(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
      return ResponseEntity.ok().body(statusService.updateStatus(id, fields));
  }

  @DeleteMapping(value="/statuses/{id}")
  public ResponseEntity<?> deleteStatus(@PathVariable Integer id) {
    statusService.deleteStatusById(id);
      return ResponseEntity.ok().body(HttpStatus.OK);
  }
  
  
}
