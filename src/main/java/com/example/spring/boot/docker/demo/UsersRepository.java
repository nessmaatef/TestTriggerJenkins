package com.example.spring.boot.docker.demo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Short>{
	@Query("select u from Users u where u.fname = ?1")
	public  Users findByFname(String fName);
	
	
}
