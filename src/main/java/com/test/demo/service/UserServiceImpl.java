package com.test.demo.service;

import com.test.demo.domain.TeamHierarchy;
import com.test.demo.domain.User;
import com.test.demo.domain.UserAccess;
import com.test.demo.dto.UserAccessDto;
import com.test.demo.repository.TeamHierarchyRepository;
import com.test.demo.repository.UserAccessRepository;
import com.test.demo.repository.UserRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TeamHierarchyRepository teamHierarchyRepository;

  @Autowired
  private UserAccessRepository userAccessRepository;

  @Override
  public void saveUserAccess(String empId) {
    User manger = userRepository.findOneByEmpId(empId);
    List<UserAccess> userAccesses = new ArrayList<>();
    User self = userRepository.findOneByEmpId(manger.getEmpId());
    userAccesses.add(
        new UserAccess(self.getEmpId(), self.getAccessKey(), self.getCountry(), self.getEmpId(),
            self.getAccessKey(), self.getCountry()));
    addDirectReports(self, manger.getEmpId(), userAccesses);
    addManagerAndPeers(self, userAccesses);
    userAccessRepository.saveAll(userAccesses);
  }

  @Override
  public void saveAllUserAccess() {
    Iterator<User> iterator = userRepository.findAll().iterator();
    while (iterator.hasNext()) {
      saveUserAccess(iterator.next().getEmpId());
    }
  }

  @Override
  public List<UserAccessDto> getAllUserAccess() {
    List<UserAccessDto> userAccessList = new ArrayList<>();
    Iterable<UserAccess> all = userAccessRepository.findAll();
    Iterator<UserAccess> iterator = all.iterator();
    while (iterator.hasNext()) {
      userAccessList.add(new UserAccessDto(iterator.next()));
    }
    return userAccessList;
  }

  @Override
  public List<UserAccessDto> getUserAccessByEmpId(String empId) {
    List<UserAccessDto> userAccessList = new ArrayList<>();
    Iterable<UserAccess> byEmpid = userAccessRepository.findByEmpid(empId);
    Iterator<UserAccess> iterator = byEmpid.iterator();
    while (iterator.hasNext()) {
      userAccessList.add(new UserAccessDto(iterator.next()));
    }
    return userAccessList;
  }

  private void addDirectReports(User rootManager, String directManagerId,
      List<UserAccess> userAccesses) {
    List<TeamHierarchy> teamHierarchyByManagerId = teamHierarchyRepository
        .findByManagerEmpId(directManagerId);
    if (!teamHierarchyByManagerId.isEmpty()) {
      teamHierarchyByManagerId.stream().forEach(teamHierarchy -> {
        User directReport = userRepository.findOneByEmpId(teamHierarchy.getEmployee().getEmpId());
        UserAccess userAccess = new UserAccess(rootManager.getEmpId(), rootManager.getAccessKey(),
            rootManager.getCountry(),
            directReport.getEmpId(), directReport.getAccessKey(), directReport.getCountry());
        userAccesses.add(userAccess);
        addDirectReports(rootManager, directReport.getEmpId(), userAccesses);
      });
    }
  }

  private void addManagerAndPeers(User employee, List<UserAccess> userAccesses) {
    TeamHierarchy teamHierarchyByEmployee = teamHierarchyRepository
        .findOneByEmployeeEmpId(employee.getEmpId());
    if (teamHierarchyByEmployee != null) {
      String managerId = teamHierarchyByEmployee.getManager().getEmpId();
      User manager = userRepository.findOneByEmpId(managerId);
      userAccesses
          .add(new UserAccess(employee.getEmpId(), employee.getAccessKey(), employee.getCountry(),
              manager.getEmpId(), manager.getAccessKey(), manager.getCountry()));
      List<TeamHierarchy> teamHierarchyByManager = teamHierarchyRepository.findByManagerEmpId(managerId);
      if (!teamHierarchyByManager.isEmpty()) {
        teamHierarchyByManager.stream().forEach(teamHierarchy -> {
          User directReport = userRepository.findOneByEmpId(teamHierarchy.getEmployee().getEmpId());
          if (!directReport.getEmpId().equals(employee.getEmpId())) {
            UserAccess userAccess = new UserAccess(employee.getEmpId(), employee.getAccessKey(),
                employee.getCountry(), directReport.getEmpId(), directReport.getAccessKey(),
                directReport.getCountry());
            userAccesses.add(userAccess);
          }
        });
      }
    }
  }

}
