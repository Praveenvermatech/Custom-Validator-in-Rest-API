package com.developervisits.service.impl;

import com.developervisits.dao.UserRepository;
import com.developervisits.model.UserDetailModel;
import com.developervisits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired(required = true)
  private UserRepository userRepository;

  public void UserServiceImpl(UserRepository repository) {
    this.userRepository = repository;
  }

  @Override
  public List<UserDetailModel> retrieveUsers() {
    List<UserDetailModel> user = userRepository.findAll();
      return user;
  }

  @Override
  public UserDetailModel getUser(Long id) {
    Optional<UserDetailModel> user = userRepository.findById(id);
    return user.get();
  }

  @Override
  public UserDetailModel saveUser(UserDetailModel user) {
    return userRepository.save(user);
  }
}
