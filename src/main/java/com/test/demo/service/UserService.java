package com.test.demo.service;

import com.test.demo.dto.UserAccessDto;
import java.util.List;

public interface UserService {

  void saveUserAccess(String empId);

  void saveAllUserAccess();

  List<UserAccessDto> getAllUserAccess();

  List<UserAccessDto> getUserAccessByEmpId(String empId);

}
