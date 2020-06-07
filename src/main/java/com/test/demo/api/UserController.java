package com.test.demo.api;

import com.test.demo.dto.UserAccessDto;
import com.test.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(
      value = "{empId}",
      method = RequestMethod.POST,
      consumes = MediaType.TEXT_PLAIN_VALUE
  )
  public void saveUserAccess(@PathVariable String empId) {
    userService.saveUserAccess(empId);
  }

  @RequestMapping(
      value = "all",
      method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public void saveAllUserAccess() {
    userService.saveAllUserAccess();
  }

  @RequestMapping(
      value = "",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<UserAccessDto> getAllUserAccess() {
    return userService.getAllUserAccess();
  }


  @RequestMapping(
      value = "{empId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<UserAccessDto> getUserAccess(@PathVariable("empId") String empId) {
    return userService.getUserAccessByEmpId(empId);
  }

}
