package com.example.trelloclone.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.trelloclone.exception.NotFoundException;
import com.example.trelloclone.model.Status;
import com.example.trelloclone.repository.IStatusRepository;


@Service
@Transactional
public class StatusService implements IStatusService {

  @Autowired
  private IStatusRepository statusRepository;

  @Override
  public Status createStatus(Status status) {
    return statusRepository.save(status);
  }

  @Override
  public Status getStatusById(Integer id) {
    Optional<Status> statusData = statusRepository.findById(id);
    if(statusData.isPresent()){
      return statusData.get();
    }else {
      throw new NotFoundException("Status not found.");
    }
  }

  @Override
  public List<Status> getAllStatuses() {
    return statusRepository.findAll();
  }

  @Override
  public Status updateStatus(Integer id, Map<String, Object> fields) {
    Optional<Status> statusData = statusRepository.findById(id);
    if(statusData.isPresent()){
      Status updatedStatus = statusData.get();
      // Map key is field name, v is value
      fields.forEach((k, v) -> {
        // use reflection to get field k on ticket and set it to value v
        Field field = ReflectionUtils.findRequiredField(Status.class, k);
        field.setAccessible(true);
        ReflectionUtils.setField(field, updatedStatus, v);
      });
      this.statusRepository.save(updatedStatus);
      return updatedStatus;
    }else {
      throw new NotFoundException("Status not found.");
    }
  }

  @Override
  public void deleteStatusById(Integer id) {
    Optional<Status> statusData = this.statusRepository.findById(id);
    if (statusData.isPresent()) {
      this.statusRepository.delete(statusData.get());
    }else {
      throw new NotFoundException("Status not found.");
    }
  }

  @Override
  public List<Status> getAllStatusByBoardId(Integer boardId) {
    return this.statusRepository.findByBoardId(boardId);
  }
}
