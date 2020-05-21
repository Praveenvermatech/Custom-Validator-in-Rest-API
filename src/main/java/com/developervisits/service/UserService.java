package com.developervisits.service;

import com.developervisits.model.UserDetailModel;

import java.util.List;

public interface UserService {

    public List<UserDetailModel> retrieveUsers();

    public UserDetailModel getUser(Long id);

    public UserDetailModel saveUser(UserDetailModel user);
}
