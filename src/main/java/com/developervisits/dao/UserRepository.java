package com.developervisits.dao;

import com.developervisits.model.UserDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetailModel, Long> {

}
