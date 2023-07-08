/**
 * 
 */
package com.ravi.learning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ravi.learning.domain.Employee;

/**
 * @author 004KDG744
 *
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
