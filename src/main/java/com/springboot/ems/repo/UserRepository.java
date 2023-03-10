package com.springboot.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.ems.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM USERS u WHERE u.username = :username", nativeQuery = true)
	public User getUserByUsername(@Param("username") String username);


	@Query(value = "SELECT * FROM USERS u WHERE u.username != :username AND u.user_id != 1", nativeQuery = true)
	public List<User> getAllEmployeesNot(@Param("username") String username);

	@Query(value = "SELECT * FROM users u LEFT JOIN (SELECT rate_to,AVG(rate) as 'avg' FROM rating r group by rate_to) v on v.rate_to = u.user_id WHERE u.user_id !=  :id", nativeQuery = true)
	public List<User> getAllEmployeesNotWithRating(@Param("id") Integer id);
}