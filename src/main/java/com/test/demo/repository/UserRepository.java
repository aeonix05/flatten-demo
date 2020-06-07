package com.test.demo.repository;

import com.test.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

  User findOneByEmpId(String empId);

}
