package com.test.demo.repository;

import com.test.demo.domain.UserAccess;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccessRepository extends CrudRepository<UserAccess, String> {

  List<UserAccess> findByEmpid(String empid);

}
