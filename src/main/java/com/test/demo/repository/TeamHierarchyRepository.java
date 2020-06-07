package com.test.demo.repository;

import com.test.demo.domain.TeamHierarchy;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TeamHierarchyRepository extends CrudRepository<TeamHierarchy, String> {

  List<TeamHierarchy> findByManagerEmpId(String managerId);

  TeamHierarchy findOneByEmployeeEmpId(String empId);

}
