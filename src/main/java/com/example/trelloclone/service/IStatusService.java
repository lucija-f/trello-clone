package com.example.trelloclone.service;

import java.util.List;
import java.util.Map;

import com.example.trelloclone.model.Status;

public interface IStatusService {

  Status createStatus(Status status);

  Status getStatusById(Integer id);

  List<Status> getAllStatuses();

  Status updateStatus(Integer id, Map<String, Object> fields);

  void deleteStatusById(Integer id);
  
  
}
